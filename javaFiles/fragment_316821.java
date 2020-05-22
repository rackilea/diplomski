public String traverse(TreeNode root, TreeNode p, String s) {
    if (root == p) {
        return s;
    }
    if (root.left != null) {
        String result = traverse(root.left, p, s + "0");
        if (!"-1".equals(result)) {
            return result;
        }
    }
    if (root.right != null) {
        return traverse(root.right, p, s + "1");
    }
    return "-1";
}