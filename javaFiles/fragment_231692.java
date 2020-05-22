public static boolean isElementinTree(int num, BinaryTreeNode root) 
{
    return root != null && (root.getData() == num ||
                            isElementInTree(num, root.getLeft()) ||
                            isElementInTree(num, root.getRight()));
}