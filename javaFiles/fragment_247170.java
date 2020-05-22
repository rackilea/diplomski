public Node<E> remove() {
    Node<E> tmpNode = start;
    if (size > 1) {
        // Move five nodes from the start
        for(int i = 0; i < 5; i++)
            tmpNode = tmpNode.getNext();

        // Move the start and cursor nodes if
        // they are about to be removed.
        if (tmpNode.equals(start))
            start = start.getNext();
        if (tmpNode.equals(cursor))
            cursor = cursor.getNext();

        // Remove the fifth node
        Node<E> next = tmpNode.getNext();
        Node<E> prev = tmpNode.getPrev();
        prev.setNext(next);
        next.setPrev(prev);

        size--;
    } else if (size == 1) {
        start = null;
        cursor = null;

        size--;
    }
    return tmpNode;
}