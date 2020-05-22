public GNode deleteNode(E e) {

    GNode current = findNode(head, e); // This finds Node: [B]

    // a node with data e doesn't exist
    if (current == null) {
        return null;
    }

    // get the next and previous node
    GNode previous = current.previous;
    GNode next = current.next;

    // current node is head
    if (previous == null) {
        this.head = current.next;
        this.head.previous = null;
    }

    // current node is tail
    if (next == null) {
        this.tail = current.previous;
        this.tail.next = null;
    }

    if (previous != null || next != null) {
        GNode temp = current.previous;
        temp.next = current.next;
        temp = current.next;
        temp.previous = current.previous;
    }

    return current;
}