public void removeLastNode() {
    if (head == null) {
        throw new IllegalStateException();
    }
    if (head == tail) {
        head = null;
        tail = null;
    } else {
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }
}