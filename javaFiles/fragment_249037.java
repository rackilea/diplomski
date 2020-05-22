public boolean hasPathSumRec(TreeNode node, int currentSum, int sum) {
    if (isLeaf(node) && sum == currentSum + node.val) {
        return true;
    } else {
        boolean result = false;
        if (node.left != null) {
            result = result || hasPathSumRec(node.left, currentSum + node.val, sum);
        }
        if (node.right != null) {
            result = result || hasPathSumRec(node.right, currentSum + node.val, sum);
        }
        return result;
    }
    return false;
}