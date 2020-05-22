Node findNode(Node root, String value) {
    if (root == null) return null; // no such node
    if (value.equals(root.getValue())) return root; // the node itself contains the value

    Node n = findNode(root.getLeft(), value); // search left sub-tree
    if (n != null) return n; // we've found it in the left sub-tree

    return findNode(root.getRight(), value); // search right sub-tree
}