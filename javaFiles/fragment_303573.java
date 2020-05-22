public class NullValuesIgnorerConcurrentHashMap<K, V>
    extends ConcurrentHashMap<K, V> {

    @Override
    public V put(K key, V value) {
        return value != null ? super.put(key, value) : null;
    }
}