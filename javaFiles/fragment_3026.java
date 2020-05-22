static void reverseTree(final TreeNode root) {
    final TreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;

    if (root.left != null) {
        reverseTree(root.left);
    }

    if (root.right != null) {
        reverseTree(root.right);
    }
}