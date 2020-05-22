public void deleteAll(int data) {
    while (head != null && head.data == data) {
        head = head.next;
        size -= 1;
    }

    if (head == null) {
        return;
    }

    Node current = head;
    while (current.next != null) {
        if (current.next.data == data) {
            current.next = current.next.next;
            size -= 1;
        } else {
            current = current.next;
        }
    }
}