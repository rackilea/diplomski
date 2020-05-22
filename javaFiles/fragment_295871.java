Set<Integer> priorityMapKeySet = priorityMap.keySet();
for (Map<Method, EventListener> mapping : priorityMap.values()) {
    if (priorityMapKeySet.contains(mapping.getKey().getAnnotation(EventHandler.class).priority().ordinal())) {
        mapping.getKey().invoke(mapping.getValue(), event);
        if (cancellable && cancellableEvent.isCancelled()) return;
    }
}