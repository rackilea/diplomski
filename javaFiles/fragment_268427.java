import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
    private static final AtomicInteger ticketCounter = new AtomicInteger();
    private final int ticketId;
    private final String movieTitle; // Or a reference to a Movie...

    public Ticket(String movieTitle) {
        this.movieTitle = movieTitle;
        this.ticketId = ticketCounter.incrementAndGet();
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
}