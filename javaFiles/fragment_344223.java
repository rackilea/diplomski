public void inOrderTraverseTree(Node focusNode) {
    if (focusNode != null) {
        // Traverse the left node
        inOrderTraverseTree(focusNode.leftChild);
        // Visit the currently focused on node
        System.out.println(focusNode);
        // Traverse the right node
        inOrderTraverseTree(focusNode.rightChild);
    }
}