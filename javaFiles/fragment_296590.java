class TreeNode {
    // ... skipping other TreeNode fields.
    public boolean isLeaf() { return left == null && right == null; } 
    public boolean hasPathSum(int sum) {
        return isLeaf() ? sum == val : 
            (left != null && left.hasPathSum(sum - val)) ||
            (right != null && right.hasPathSum(sum - val);
    }
}