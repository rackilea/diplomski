put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}

putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)
    n = (tab = resize()).length;
    ....
}

final Node<K,V>[] resize() {
     //many levels of checks before resizing   
}