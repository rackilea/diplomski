if (head.data == x) {
    head = head.next;
} else {
    Node temp = head;
    while (temp.next != null) {
        if (temp.next.data.equals(x)) {
            temp.next = temp.next.next;
            break;
        } else {
            temp = temp.next;
        }
    }
}