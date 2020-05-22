public Node find(int v) {
    Node current = this;
    // Keep navigating down the tree until either we've run
    // out of nodes to look at, or we've found the right value.
    while (current != null && current.value != v) {
        current = v < current.value ? current.left : current.right;
    }
    return current;
}