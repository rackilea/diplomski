public class ConcurrentLru<K, V> {

    final Object mutex = new Object();
    final Map<K, V> cache;

    public ConcurrentLru(final int cacheSize) {
        this.cache = new LinkedHashMap<K, V>() {

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return this.size() > cacheSize;
            }
        };
    }

    public void put(K k, V v) {
        synchronized (this.mutex) { this.cache.put(k, v); }
    }

    public boolean contains(K k) {
        synchronized (this.mutex) { return this.cache.containsKey(k); }
    }

    public V remove(K k) {
        synchronized (this.mutex) { return this.cache.remove(k); }
    }

    public V get(K k) {
        synchronized (this.mutex) { return this.cache.get(k); }
    }
}