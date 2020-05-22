public class BigEventFilter implements Filter {

    @Override
    public boolean filter(Event event) {
        return event.getAttendeeCount() > 100;
    }
}