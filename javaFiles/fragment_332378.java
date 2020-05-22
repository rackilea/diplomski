void reverseList(Node node) {
    if (node == null) return;      // Reverse of empty list is itself.
    if (node.next == null) return; // Reverse of singleton list is itself.

    reverseList(node.next); // Reverse the rest of the list
    appendNodeToList(node, node.next); // Append the new value.
}