static void reverseTree(final TreeNode root) {
    if (root == null) {
        return;
    }

    final TreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;

    reverseTree(root.left);

    reverseTree(root.right);
}