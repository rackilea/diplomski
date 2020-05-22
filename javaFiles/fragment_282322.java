if (head == null) {
    head = newNode;
} else {
    tail.next = newNode;
}
tail = newNode;