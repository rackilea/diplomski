public interface Entry<K, V> {

    K getKey();

    V getValue();

    void setValue(V value);
}

public interface HashTableInterface<K, V> extends Iterable<Entry<K, V>> {

    boolean isEmpty();

    V get(K key);

    void add(K key, V value);

    void remove(K key);

    void clear();
}