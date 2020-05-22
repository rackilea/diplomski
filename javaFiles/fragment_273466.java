Node before = null;
Node tmp = head;
while (tmp != null) {
    Node next = tmp.next;
    tmp.next = before;
    before = tmp;
    tmp = next;
}
head = before;