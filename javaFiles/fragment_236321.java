public BinaryTreeNode<CharData> findChar(char ch, BinaryTreeNode<CharData> root){
    if (root == null) {
        return null;
    }
    if (root.getValue().getChar() == ch){
        return root;
    }
    if (root.getValue().getChar() > ch) {
        return findChar(ch, root.getLeft());
    } else {
        return findChar(ch, root.getRight());
    }
}