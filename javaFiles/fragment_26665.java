public enum Singleton { 
    INSTANCE;

private Singleton() {
    hashmap.put(1, new MyObject(1, 1));
}

public static Singleton getInstance() {
    return INSTANCE;
}

private final Map<Integer, MyObject> hashmap = new HashMap<>();

public synchronized MyObject get() {
    // safe is all you need to do is read one value.
    return hashmap.get(1);
}

public synchronized void update() {
    hashmap.get(1).setCount(hashmap.get(1).getCount() + 1);
}
}