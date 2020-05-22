public SLL<E> reverse() {
    SLL<E> result = new SLL<E>();

    // copy Nodes into new list, in reverse order.
    //
    Node<E> read = this.first;
    while (read != null) {
        // insert Copy, first;
        Node<E> copy = new Node<E>( read.getItem());
        copy.next = result.first;
        result.first = copy;
        // advance 'Read Position'.
        read = read.next;
    }

    // done.
    return result;
}