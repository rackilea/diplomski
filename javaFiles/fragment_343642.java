private int inOrder(Node<T> node, T[] array, int i) {
    if (node != null) {
        i = inOrder(node.leftChild(), array, i);
        array[i++] = node.data();
        i = inOrder(node.rightChild(), array, i);
    }
    return i;
}