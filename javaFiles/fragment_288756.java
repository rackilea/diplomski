public class LazyMap<K, V> implements Map<K, V> {

    private Map<K, V> nestedMap;
    private Class<V> valueType;

    public LazyMap(Class<V> valueType) {
        nestedMap = new HashMap<K, V>();
        this.valueType = valueType;
    }

    @Override
    public void clear() {
        nestedMap.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return nestedMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return nestedMap.containsValue(value);
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return nestedMap.entrySet();
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(Object key) {
        if (!containsKey(key)) {
            try {
                put((K) key, valueType.newInstance());
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
        return nestedMap.get(key);
    }

    @Override
    public boolean isEmpty() {
        return nestedMap.isEmpty();
    }

    @Override
    public Set<K> keySet() {
        return nestedMap.keySet();
    }

    @Override
    public V put(K key, V value) {
        return nestedMap.put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        nestedMap.putAll(m);
    }

    @Override
    public V remove(Object key) {
        return nestedMap.remove(key);
    }

    @Override
    public int size() {
        return nestedMap.size();
    }

    @Override
    public Collection<V> values() {
        return nestedMap.values();
    }

}