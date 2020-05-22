public static void rotateRight(Node node) {
    assert(!node.isLeaf() && !node.left.isLeaf());
    final Node child = node.left;
    node.setLeft(child.right);
    if (node.isRightChild())
         node.parent.setRight(child);
    else node.parent.setLeft(child);
    child.setRight(node);
}