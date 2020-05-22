find head and tail of list
while (head != tail) {
    if (head.value != tail.value)
        return false;
    head = head.next;
    tail = tail.prev;
}