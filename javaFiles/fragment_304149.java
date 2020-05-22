public ArrayList<T> postOrder(BinarySearchTree<T> tree) {
    if (tree == null) {
        return null;
    } else {
        ArrayList<T> post = new ArrayList<T>();
        ArrayList<T> l = postOrder(tree.left);
        if (l != null) post.addAll(l);
        ArrayList<T> r = postOrder(tree.right);
        if (r != null) post.addAll(r);
        post.add(tree.thing);
        return post;
    }
}