if (root.left != null) {
    List<TreeNode> acc = new ArrayList<>(l);
    acc.add(root.val);
    rec(root.left, acc, lists);
}

if (root.right != null) {
    List<TreeNode> acc = new ArrayList<>(l);
    acc.add(root.val);
    rec(root.right, acc, lists);
}