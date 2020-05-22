public int twoChildren(TreeNode<Integer> root){

   if (root == null)
    return 0;

   if (root.right != null && root.left != null)
    return 1 + twoChildren(root.left) + twoChildren(root.right);

    return twoChildren(root.left) + twoChildren(root.right);
}