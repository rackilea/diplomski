public V put(K key, V value) {
        Entry<K,V> t = root;
        if (t == null) {
            compare(key, key); //this is the culprit

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
    ……………
    ……………
    ……………
}