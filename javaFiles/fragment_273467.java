Node reversedPart = null;
Node current = head;
while (current != null) {
    Node next = current.next;
    current.next = reversedPart;
    reversedPart = current;
    current = next;
}
head = reversedPart;