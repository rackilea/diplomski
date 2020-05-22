public static boolean isBinarySearchTree(Node node, int key) {
    if (node.leftchild != null && node.leftchild.key < key || node.rightchild != null && node.rightchild.key > key) {
        return false;
    } else {
        return (node.leftchild != null ? isBinarySearchTree(node.leftchild, node.leftchild.key) : true) && (node.rightchild != null ? isBinarySearchTree(node.rightchild, node.rightchild.key) : true);
    }
}