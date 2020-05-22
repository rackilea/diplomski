public void preorderTraverseTree(Node focusNode) {
    if (focusNode != null) {
        System.out.println(focusNode);

        preorderTraverseTree(focusNode.leftChild);
        preorderTraverseTree(focusNode.rightChild);
    }
}