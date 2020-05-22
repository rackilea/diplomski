public class Seat {
    public void book() { 
        if (this.isBooled) {
           throw new CannotBookException("seats is taken!");
        }
        this.isBooled = true;
    }
}

public class SeatTest {
    @Test // when I book a seat, it's markedas booked.
    public void testBook() {
        final Seat seat = new Seat();
        seat.book();
        assertTrue(seat.isBooked)
    }

    @Test(expected = CannotBookException.class) // when I book an already booked seat, I get an exception.
    public void testBookAlreadBooked() {
        final Seat seat = new Seat();
        // book the seat
        seat.book();
        assertTrue(seat.isBooked)

        // try to book again
        seat.book();
    }
}