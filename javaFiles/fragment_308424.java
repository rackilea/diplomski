private final ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
private final Set<Object> beforeStart = new HashSet<>();
private final AtomicBoolean running = new AtomicBoolean();
public void start() {
    synchronized (beforeStart) {
       for (Object obj : beforeStart) {
            doIfAbsent(obj);
       }
       running.set(true);
    }
}
public void addObject(Object obj) {
    if (running.get()) {
        doIfAbsent(obj);
    } else {
        synchronized (beforeStart) {
            // we have to test running again once we get the lock
            if (running.get()) {
                doIfAbsent(obj);
            } else {
                beforeStart.add(obj);
            }
        }
    }
}
private void doIfAbsent(Object obj) {
    if (map.putIfAbsent(obj, obj)) {
        someApi.someApiMethod(obj);
    }
}