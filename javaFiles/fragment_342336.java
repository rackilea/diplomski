private void inOrder(Node node) {
    if (node != null) {
        if(node.left != null)
            inOrder(node.left);
        System.out.print(node.data + " ");
        if(node.right != null)
            inOrder(node.right);
    } else {
        System.out.print("*" + " ");
    }
}