private final Set<Object> set = new HashSet<>();
public void start() {
    synchronized (set) {
        set.forEach(someApi::someApiMethod);
    }
}
public void addObject(Object obj) {
    synchronized (set) {
            if (set.add(obj)) {
                someApi.addObject(obj);
            }
        }
    }
}