public void helper(TreeNode root, int sum, ArrayList<Integer> path, int level, List<List<Integer>> results) {
    if (root == null) return;
    int tmp = sum;
    path.add(root.val);
    for (int i = level;i >= 0; i--) {
        tmp -= path.get(i);
        if (tmp == 0) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = i; j <= level; ++j)
                temp.add(path.get(j));
            results.add(temp);
        }
    }
    findSum(head.left, sum, path, level + 1, results);
    findSum(head.right, sum, path, level + 1, results);
    buffer.remove(buffer.size() - 1);
}