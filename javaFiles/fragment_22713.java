T search(Node tree, T val) {
    int delta = tree.getValue.compareTo(val);
    if (delta == 0) {
        return tree.getValue;
    } else if (delta > 0) {
        return (tree.getRight() == null) ? null : search(tree.getRight(), val);
    } else {
        return (tree.getLeft() == null) ? null : search(tree.getLeft(), val);
    }
}