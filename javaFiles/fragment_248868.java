public class SimpleLru<K, V> extends LinkedHashMap<K, V>{

    final int cacheSize;

    public SimpleLru(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this.cacheSize;
    }

    public static void main(String[] args) {
        SimpleLru<String, Integer> m = new SimpleLru<>(2); // Max 2
        m.put("k1", 1); // k1:1
        m.put("k2", 2); // k1:1, k2:2
        m.put("k3", 3); // k2:2, k3:3
    }
}