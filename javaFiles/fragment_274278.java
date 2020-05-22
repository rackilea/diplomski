private ArrayList<T> collect(AVLTree<T> tree, AVLNode<T> tRoot, ArrayList<T> l) {

    ArrayList<T> nodes = l;

    if (tRoot == null)
        return null;

    if (!nodes.contains(tRoot.element())) {
        nodes.add(tRoot.element());
        collect(tree, tRoot.getRight(), nodes); // this is safe since null check exists at top
        collect(tree, tRoot.getLeft(), nodes);
    }

    return nodes;

}