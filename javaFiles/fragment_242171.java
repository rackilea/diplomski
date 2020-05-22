public class EventListener<T extends Event> {

    private final EventHandler<T> handler;
    private final Class<T> eventClass;

    public EventListener(EventHandler<T> handler, Class<T> eventClass) {
        if (handler == null) {
            throw new NullPointerException();
        }
        if (eventClass == null) {
            throw new NullPointerException();
        }
        this.handler = handler;
        this.eventClass = eventClass;
    }

    public boolean isApplicable(Event event) {
        return this.eventClass.isInstance(event);
    }

    public void onEvent(T event) {
        handler.handle(event);
    }
}