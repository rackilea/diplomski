private void addAfter(T ele, Node<T> after) {
    Node<T> newN = new Node<T>(ele, after, after.getNext());
    after.getNext().setPrev(newN);
    after.setNext(newN);
    size++;
}