public static <E> BinarySearchTree<E> create(Comparator<? super E> comp) {
    return new ComparatorSearchTree(comp);
}

public static <E extends Comparable<E>> BinarySearchTree<E> create() {
    return new ComparableSearchTree();
}