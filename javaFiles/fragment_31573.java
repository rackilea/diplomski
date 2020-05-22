class SoftConcurrentMap<K, V> extends ConcurrentHashMap<SoftReference<K>, SoftReference<V>> {
    ConcurrentHashMap<SoftReference<K>, SoftReference<V>> map = new ConcurrentHashMap<>();

    V public void get(Object key) {
        SoftReference<V> value = map.get(new SoftRefrence(key));
        if(value != null && value.get() != null) {
            return value.get();
        } else {
            map.remove(new SoftReference(key));
            return null;
        }
    }

    V put(K key, V value) {
        SoftReference<V> oldValue = map.put(new SoftReference(key), new SoftReference(value));
        return oldValue == null ? null : oldValue.get();
    }
}