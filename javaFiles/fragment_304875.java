public void addLast(E e) {
    // create a new node and add to the tail of the list
    Node<E> newest = new Node<>(e, null);
    if (size == 0) {
        tail = head; // special case for the first item
    }
    else {
        tail.setNext(newest);
    }

    tail = newest;
    size++;
}