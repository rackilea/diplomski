public void inOrderTraversal(Node node) {
    if(node==null) return;

    inOrderTraversal(node.left);
    System.out.println(node.value);
    inOrderTraversal(node.right);
}