private Node add(Node node, T item) {
    if (node == null) {
        return new Node(item);
    }

    int cmp = item.compareTo(node.item);

    if (cmp == 0) {
        // it already exists
    } else if (cmp < 0) {
        node.left = add(node.left, item);
    } else {
        node.right = add(node.right, item);
    }

    return node;
}