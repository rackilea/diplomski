public Node reverseList(Node head) {
    Node focusNode = head;          // focusNode = 1
    head = null;
    while (focusNode != null) {
      Node parent = focusNode;      // parent = 1
      focusNode = focusNode.next;   // focusNode = 2; moving over the list...
      parent.next = head;           // parent.next = null (1 -> null)
      head = parent;                // head = 1
    }
    return head;
}