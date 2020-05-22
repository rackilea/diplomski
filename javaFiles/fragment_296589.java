public boolean hasPathSum(TreeNode root, int sum) {
    // If we've reached a null child, the other child is non-null,  so we're
    // not at a leaf, so there no way this can be a leaf-to-path sum.
    // See below for why this is the case.
    if (root == null) {
        return false;
    }
    // If we're at a leaf (null children), then we've found the path
    // if and only if the node value exactly equals the sum we're looking for. 
    if (root.left == null && root.right == null) {
        return (sum == root.val);
    }
    // We're not at a leaf.  See if we can find the remaining part of the sum
    // by searching the children.  Null children are handled above.  If the
    // sum is found in the left subtree, the short-circuit evaluation of ||
    // will skip searching the right.
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}