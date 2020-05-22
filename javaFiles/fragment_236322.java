public BinaryTreeNode<CharData> findChar(char ch, BinaryTreeNode<CharData> root){
    if (root == null) {
        return null;
    }
    if (root.getValue().getChar() == ch){
        return root;
    }
    BinaryTreeNode<CharData> answer = findChar(ch, root.getLeft());
    if (answer != null) {
        return answer;
    } else {
        return findChar(ch, root.getRight());
    }
}