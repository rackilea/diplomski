final class ImmutableMap<K, V> implementsMap<K, V> {
    private Map<K, V> map;

    public ImmutableMap(Map<K, V> map) {
        this.map = new HashMap<>(map);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        if(!map.containsKey(key)) {
            throw new IllegalArgumentException("Cannot add new keys!");
        }

        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("You cannot remove entries from this map!");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for(K key : map.keySet()) {
            if(!this.map.containsKey(key)) {
                throw new IllegalArgumentException("Cannot add new keys to this map!");
            }
        }

        this.map.putAll(map);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("You cannot remove entries from this map!");
    }

    @Override
    public Set<K> keySet() {
        return Collections.unmodifiableSet(map.keySet());
    }

    @Override
    public Collection<V> values() {
        return Collections.unmodifiableSet(map.values()); //prevebt changing values to null
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        //to allow modification of values, create your own ("immutable") entry set and return that
        return Collections.unmodifiableSet(map.entrySet()); 
    }
}