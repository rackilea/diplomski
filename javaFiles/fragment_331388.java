public <T extends MyContainedObject> addChangeListener(Class<T> klass,
                                                       ChangeListener<? super T> listener) {
    ...
}    

private <T extends MyContainedObject> Set<ChangeListener<? super T>> getChangeListeners(T obj) {
    Set<ChangeListener<? super T>> result = new IdentityHashSet<ChangeListener<? super T>>();
    for (Map.Entry<Class<? extends MyContainedObject>, Set<ChangeListener<?>>> entry : listeners.entrySet()) {
        if (entry.getKey().isInstance(obj)) {
            // safe because signature of addChangeListener guarantees type match
            @SuppressWarnings("unchecked")
            Set<ChangeListener<? super T>> listeners =
                (Set<ChangeListener<? super T>>) entry.getValue();
            result.addAll(listeners);
        }
    }
    return result;
}