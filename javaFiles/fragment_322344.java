private void addIterative(T item) {
    if (root == null) {
        root = new Node(item);
        return;
    }

    Node parent = null;
    Node node = root;

    int cmp = 0;
    while (node != null) {
        cmp = item.compareTo(node.item);

        if (cmp == 0) {
            return;
        } else if (cmp < 0) {
            parent = node;
            node = node.left;
        } else {
            parent = node;
            node = node.right;
        }
    }

    Node child = new Node(item);

    if (cmp < 0) {
        parent.left = child;
    } else if (cmp > 0) {
        parent.right = child;
    }
}