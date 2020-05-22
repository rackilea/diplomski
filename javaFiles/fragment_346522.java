final AtomicReference<Map<K, V>> mapRef = new AtomicReference<>();

// assuming you don't modify the map after calling this.
public void update(Map<K, V> map) {
    mapRef.set(map);
}

public V get(K key) {
    // this will always see the latest complete map.
    return mapRef.get().get(key);
}