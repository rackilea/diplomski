T search(Node tree, T val) {
    if (tree == null)
         return null;
    int delta = tree.getValue.compareTo(val);
    if (delta == 0) {
        return tree.getValue;
    } else if (delta > 0) {
        return search(tree.getRight(), val);
    } else {
        return search(tree.getLeft(), val);
    }
}