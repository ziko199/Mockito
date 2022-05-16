package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Test13StrictStubbing {
    @InjectMocks
    private BookingService bookingService;
    @Mock
    private PaymentService paymentServiceMock;
    @Mock
    private RoomService roomServiceMock;
    @Mock
    private BookingDAO bookingDAOMock;
    @Mock
    private MailSender mailSenderMock;

    @Test
    void should_InvokePayment_When_Prepaid() {
        // given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 5),
                2, false);

        lenient().when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1");

        // when
        bookingService.makeBooking(bookingRequest);

        // then
        //no exception is thrown
        System.out.println("no exception is thrown");
    }

}