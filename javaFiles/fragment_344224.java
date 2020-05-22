public void postOrderTraverseTree(Node focusNode) {
    if (focusNode != null) {
        postOrderTraverseTree(focusNode.leftChild);
        postOrderTraverseTree(focusNode.rightChild);

        System.out.println(focusNode);
    }
}