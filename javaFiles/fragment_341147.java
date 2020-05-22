class EventDispatcher<T extends AbstractEvent> {
    private final List<Listener<? super T>> listeners =
        new CopyOnWriteArrayList<Listener<? super T>>();
    public void addListener(Listener<? super T> listener) {
        listeners.add(listener);
    }
    public void dispatchEvent(T event) {
        for (Listener<? super T> listener : listeners) 
            listener.process(event);
    }

}