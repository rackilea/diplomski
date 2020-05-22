static void clear(Node root) {
    while (root != null) {
        Node left = root.left;
        if (left == null) {
            Node right = root.right;
            root.right = null;
            root = right;
        } else {
            // Rotate the left child up.
            root.left = left.right;
            left.right = root;
            root = left;
        }
    }
}