static class Entry<K,V> implements Map.Entry<K,V> {
    final K key;
    V value;
    Entry<K,V> next;  <-- This one refers to the next element
    int hash
..
}