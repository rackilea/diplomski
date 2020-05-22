public void deleteAll(int data) {
    Node dummy = new Node();
    dummy.next = head;

    Node current = dummy;
    while (current.next != null) {
        if (current.next.data == data) {
            current.next = current.next.next;
            size -= 1;
        } else {
            current = current.next;
        }
    }

    head = dummy.next;
}