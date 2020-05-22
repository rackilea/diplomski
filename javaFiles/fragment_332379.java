void reverseList(Node node) {
    if (node == null) return;      // Reverse of empty list is itself.
    if (node.next == null) return; // Reverse of singleton list is itself.

    reverseList(node.next); // Reverse the rest of the list
    node.next.next = node; // Append the new value.
}