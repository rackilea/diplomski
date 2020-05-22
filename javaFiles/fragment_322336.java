public void pathSumRe(TreeNode root, int sum, List<List<Integer>> res,
        ArrayList<Integer> path) {
    if (root == null) {
        return;
    }
    path.add(root.val);
    if (root.left == null && root.right == null && root.val == sum) {
        res.add(new ArrayList<Integer>(path));
    }
    pathSumRe(root.left, sum - root.val, res, new ArrayList<Integer>(path));
    pathSumRe(root.right, sum - root.val, res, new ArrayList<Integer>(path));
}