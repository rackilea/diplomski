Node Reverse(Node head) {
  if (head == null) return null;

  Node current = head;

  while (current != null) {
    Node temp = current.next;
    current.next = current.prev;
    current.prev = temp;

    current = temp;
}
return current;