class EventDispatcher<T extends AbstractEvent> {
    private final List<Listener<T>> listeners =
        new CopyOnWriteArrayList<Listener<T>>();
    public void addListener(Listener<T> listener) {
        listeners.add(listener);
    }
    public void dispatchEvent(T event) {
        for (Listener<T> listener : listeners) 
            listener.process(event);
    }

}