public Node reverse(Node head) {
    Node node = head;
    if (node.next == null) {
        head = node;
        return head;
    }
    Node next = node.next;

    // fix for problem 2, we transform the current node in the tail
    node.next = null;

    // fix for problem 1, head is now the tail node
    head = reverse(next);   

    next.next = node;

    return head;
}