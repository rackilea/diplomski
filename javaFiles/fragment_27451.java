private DListNode<Entry<K,V>> findNode(K key){
    DListNode<Entry<K, V>> node = head;

    while(node != null && !specialEquals(node.getElement().getKey(),key))
        node = node.getNext();

    return node;
}

private static boolean specialEquals(K key1, K key2) {
    if( key1 instanceof String && key2 instanceof String ) {
        return ((String) key1).equalsIgnoreCase((String) key2);
    } else {
        return key1.equals(key2);
    }
}