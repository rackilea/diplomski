public class Room {
    private Seat[][] seats;
    public String toString() {
        // like showSeatPlan() using toString() of Seat
    }
}

public class Seat {
    private int row, column;
    private boolean isBooked;
    public void book() { /* ... */ }
    public void cancel() { /* ... */ }
    public String toString() { /* "X" or " " */ }
}

public final class Scheduler {
   // "main class" with a "main" method
}

public class Menu {
    private Room room;
    public String toString() {
        // print out menu
    }
    public void bookSeat() { /* ... */ }
    public void cancelSeat() { /* ... */ }
}