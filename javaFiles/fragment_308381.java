static BinaryNode build(int i, int j) {
    if (i > j) return null;

    int mid = (i + j) / 2;  // Assumes i >= 0.

    BinaryNode node = new BinaryNode();
    node.data = mid;

    node.left = build(i, mid - 1);
    if (node.left != null) node.left.parent = node;

    node.right = build(mid + 1, j);
    if (node.right != null) node.right.parent = node;

    return node;
}