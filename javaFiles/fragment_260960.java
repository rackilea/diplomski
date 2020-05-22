public void insertNodeSorted(Node x) {
    if (root == null) {    
        root = x;
        return;
    }
    insertNodeSorted(x, root);
}