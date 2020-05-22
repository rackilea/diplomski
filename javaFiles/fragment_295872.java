private final static class Registry {

    private final static Map<String, Set<Integer>>  prioritySetByEventMap = new HashMap<>();
    private final static Map<String, EventListener> eventListenerByEventAndPriorityMap = new HashMap<>();
    private final static Map<String, Method> methodByEventAndListenerMap = new HashMap<>();

    public static Set<Integer> getPrioritySetByEvent(Class<Event> event) {
        return prioritySetByEventMap.get(event.getName());
    }

    public static synchronized void registerEventByPriority(Class<Event> event, Integer priority) {
        Set<Integer> ps = prioritySetByEventMap.get(event.getName());
        if(ps == null) {
            ps = new HashSet<>();
            prioritySetByEventMap.put(event.getName(), ps);
        }
        ps.add(priority);
    }

    public static EventListener getEventListenerByEventAndPriority(Class<Event> event, Integer priority) {
        String key = event.getName() + "-" + priority;
        return eventListenerByEventAndPriorityMap.get(key);
    }

    public static synchronized void registerEventListenerByEventAndPriority(Class<Event> event, Integer priority, EventListener listener) {
        String key = event.getName() + "-" + priority;
        eventListenerByEventAndPriorityMap.put(key, listener);
    }

    public static Method getMethodByEventAndListener(Class<Event> event, EventListener listener) {
        String key = listener.toString() + "-" + event.getName();
        return methodByEventAndListenerMap.get(key);
    }

    public static synchronized void registerMethodByEventAndListener(Class<Event> event, EventListener listener, Method method) {
        String key = listener.toString() + "-" + event.getName();
        methodByEventAndListenerMap.put(key, method);
    }
}