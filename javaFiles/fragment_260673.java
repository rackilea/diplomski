public class EventHandlerRepository {
    private Map<EventType, EventHandler> handlers;

    public EventHandlerRepository() {
        handlers = new HashMap<EventType, EventHandler>();
    }

    void synchronized registerHandler(EventType type, EventHandler handler) {
        handlers.put(type, handler);
    }

    public synchronized EventHandler getHandler(EventType type) {
        return handlers.get(type);
    }
}