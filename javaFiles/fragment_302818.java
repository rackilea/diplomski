class EventSource {

    private final Map<EventType, List<Listener<? extends BaseEvent>>> listenersMap = new HashMap<EventType, List<Listener<? extends BaseEvent>>>();

    public <E extends BaseEvent> void addListener(EventType<E> eventType, Listener<E> listener) {
        listeners(eventType).add(listener);
    }

    public <E extends BaseEvent> void fire(EventType<E> eventType, E event) {
        for (Listener listener : listeners(eventType)) {
            listener.handle(event);
        }
    }

    private List<Listener<? extends BaseEvent>> listeners(EventType eventType) {
        if (listenersMap.containsKey(eventType)) {
            return listenersMap.get(eventType);
        } else {
            List<Listener<? extends BaseEvent>> listenersList = new ArrayList();
            listenersMap.put(eventType, listenersList);
            return listenersList;
        }
    }

}