public void add(K key, V value) {
    Node<K,V> node = new Node<K,V>(key, value);

    if (root == null) {
        root = node;
        currentSize++;
    } else {
        add(root, node);
    }
}