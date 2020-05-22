private ArrayList<T> collect(AVLTree<T> tree, AVLNode<T> tRoot, ArrayList<T> l) {

    ArrayList<T> nodes = l;

    if (tRoot == null)
        return null;

    else {
        if (!nodes.contains(tRoot.element())) {
            nodes.add(tRoot.element());

            if (tRoot.getRight() != null) {
                collect(tree, tRoot.getRight(), nodes);
            }

            if (tRoot.getLeft() != null) {
                collect(tree, tRoot.getLeft(), nodes);
            } 
        }
    }

    return nodes;

}