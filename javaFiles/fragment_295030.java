private static void createTree(Node root) {

    if(string.isEmpty() || root == null) {
        return;
    }

    if(string.charAt(0) == '1') {
        root.left = new Node();
    }

    if(string.charAt(1) == '1') {
        root.right = new Node();
    }
    string = string.substring(2);
    createTree(root.left);
    createTree(root.right);

}