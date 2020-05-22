private ConcurrentHashMap<Class<? extends Event>, ConcurrentLinkedQueue<? extends Consumer<? extends Collection<? extends Event>>>> listeners;

public <T extends Event> void listen(Class<T> clazz, Consumer<Collection<T>> consumer){
    ConcurrentLinkedQueue<Consumer<Collection<T>>> consumers = (ConcurrentLinkedQueue<Consumer<Collection<T>>>) listeners.get(clazz);
    if (consumers == null) {
        consumers = new ConcurrentLinkedQueue<>();
        listeners.put(clazz, consumers);
    }
    consumers.add(consumer);
}

public <T extends Event> void fire(Class<T> clazz, Collection<T> eventToFire){
    ConcurrentLinkedQueue<Consumer<Collection<T>>> consumers = (ConcurrentLinkedQueue<Consumer<Collection<T>>>) listeners.get(clazz);
    if(consumers != null){
        consumers.forEach(x -> x.accept(eventToFire));
    }
}