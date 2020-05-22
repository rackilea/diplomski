// HashMap.java -- edited for conciseness
static int indexFor(int h, int length) {
    return h & (length-1);
}

public V put(K key, V value) {
    int hash = hash(key.hashCode());
    int index = indexFor(hash, table.length);
    // ...
}