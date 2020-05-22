public class TicketsQueue<E> extends ArrayDeque<E> {

    public boolean offer(String category, String ticketId) {
        return offer((E) new SimpleEntry<String, String>(category, ticketId));
    }
}