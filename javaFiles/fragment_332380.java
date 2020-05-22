void reverseList(Node node) {
    /* Make a stack of the reverse of the nodes. */
    Stack<Node> s = new Stack<Node>();
    for (Node curr = node; node != null; node = node.next)
        s.push(curr);

    /* Start unwinding it. */
    Node curr = null;
    while (!s.empty()) {
        Node top = s.pop();

        /* If there is no node in the list yet, set it to the current node. */
        if (curr == null)
            curr = top;
        /* Otherwise, have the current node point to this next node. */
        else
            curr.next = top;

        /* Update the current pointer to be this new node. */
        curr = top;
    }
}