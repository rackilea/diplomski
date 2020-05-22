public Node find(int v) {
    Node current = this;
    while (current != null) {
        if (current.value == v) {
            return current;
        }
        // This will drop out of the loop naturally if there's no appropriate subnode
        current = v < current.value ? current.left : current.right;
    }
    return null;
}