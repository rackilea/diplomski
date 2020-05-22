EventHandlerGroup<T> eventHandlerGroup = null;
    for (T handler : handlers) {
        if (eventHandlerGroup == null) {
            eventHandlerGroup = disruptor.handleEventsWith(handler);
        } else {
            eventHandlerGroup.then(handler);
        }
    }