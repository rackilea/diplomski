static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash; // here the hash code is cached
        this.key = key;
        this.value = value;
        this.next = next;
    }
    ...
}