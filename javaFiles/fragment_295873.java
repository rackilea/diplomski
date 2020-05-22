public void registerListener(EventListener listener) {
    for (Method method : listener.getClass().getMethods()) {
        EventHandler handler = method.getAnnotation(EventHandler.class);
        if (handler != null) {
            Class<?>[] parameters = method.getParameterTypes();
            if (parameters.length == 1) {

                Class<Event> event = (Class<Event>) parameters[0];

                EventPriority priority = handler.priority();

                Registry.registerEventByPriority(event, priority.ordinal());

                Registry.registerEventListenerByEventAndPriority(event, priority.ordinal(), listener);

                Registry.registerMethodByEventAndListener(event, listener, method);

            }
        }
    }
}


public void dispatchEvent(Event event) {
    Set<Integer> prioritySet = Registry.getPrioritySetByEvent((Class<Event>) event.getClass());

    if (prioritySet != null) {
        CancellableEvent cancellableEvent = null;
        boolean cancellable;
        if (cancellable = event instanceof CancellableEvent) {
            cancellableEvent = (CancellableEvent) event;
            if (cancellableEvent.isCancelled())
                return;
        }

        try {

            for(Integer priority : prioritySet) {

                EventListener listener = Registry.getEventListenerByEventAndPriority((Class<Event>) event.getClass(), priority);

                if(listener != null) {
                    Method m = Registry.getMethodByEventAndListener((Class<Event>) event.getClass(), listener);
                    if(m != null) {
                        m.invoke(listener, event);
                        if (cancellable && cancellableEvent.isCancelled()) {
                            return;
                        }
                    }
                }
            }

        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}