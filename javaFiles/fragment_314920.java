public T min() {
    return recMin(root).getInfo();
}

public BSTnode<T> recMin(BSTnode<T> tree) {
    if (tree == null) {
        throw new NoSuchElementException();
    }
    if (tree.left == null) {
        return tree;
    }
    return recMin(tree.left);
}

public T IterationMin(BSTnode<T> tree) {
    if (tree == null) {
        throw new NoSuchElementException();
    }

    while (tree.left != null) {
        tree = tree.left;
    }
    return tree.getInfo();
}