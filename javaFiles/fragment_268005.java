private final Object mutex;

public SynchronizedMap(Map<K,V> map, Object mutex) {
    m = map;
    this.mutex = mutex;
}

public SynchronizedMap(Map<K,V> map) {
    this(map, new Object());
}