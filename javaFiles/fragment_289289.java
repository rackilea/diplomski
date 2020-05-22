private boolean hasLeftChild(int index) {
    return leftChild(index) <= size;
}
private int leftChild(int index) {
    return index * 2;
}