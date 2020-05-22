public class InstrumentedHashMap<K, V> implements Map<K, V> {

    private Map<K, V> map;

    public InstrumentedHashMap() {
        map = new HashMap<K, V>();
    }

    public boolean put(K key, V value) {
        if (map.size() >= MAX && !map.containsKey(key)) {
             return false;
        } else {
             map.put(key, value);
             return true;
        }
    }

    ...
}