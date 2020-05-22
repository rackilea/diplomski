public void reverse() {
    // Assuming `head` is the first node in linked list
    Node current = head, previous = null, forward = null;
    while (current.next != null) {
        forward = current.next;
        current.next = previous;
        previous = current;
        current = forward;
    }
    head = current;
    head.next = previous;
}