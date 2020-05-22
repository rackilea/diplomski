public class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {

    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }   

    @Override
    public int compareTo(Entry<K, V> other) {
        return key.compareTo(other.key);
    }
}