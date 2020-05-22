private int compare(Node n1, Node n2) {
    return n1.data.getbLnum().compareTo(n2.data.getbLnum());
}

void sortedInsert(Node newNode) {
    Node prev = null;
    Node next = head;

    while (next != null &&
            compare(newNode, next) >= 0) {
        prev = next;
        next = next.next;
    }

    if (prev == null) head = newNode;
    else prev.next = newNode;
    newNode.next = next;
}