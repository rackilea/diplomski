public void addLast(E e) {
    // create a new node and add to the tail of the list
    Node<E> newest = new Node<>(e, null);
    if (size == 0) {   // special case for the first item
        head = newest; // now head points to the new node
    }
    else {
        tail.setNext(newest);
    }

    tail = newest;
    size++;
}