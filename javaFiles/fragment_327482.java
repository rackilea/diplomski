class DeleteOnReadMap<K, V> implements Map<K, V> {

    private Map<K, V> m = new LinkedHashMap<K, V>();

    // implement Map "read" methods Map with delete-on-read semantics
    public V get(K key) {
        // ...
    }
    // (other read methods here)

    // implement remaining Map methods by forwarding to inner Map
    public V put(K key, V value) {
        return m.put(key, value);
    }
    // (remaining Map methods here)
}