public static List<Integer> preOrder_Array(BinaryTreeNode<Integer> root) {
    if (root == null)
        return new ArrayList<>();        // array of 0 size

    List<Integer> pre = new ArrayList<>();

    preOrder_Array_Helper(pre, root);
    return pre;
}

private static void preOrder_Array_Helper(List<Integer> pre, BinaryTreeNode<Integer> root) {
    if (root == null)
        return;

    pre.add(root.data);
    preOrder_Array_Helper(pre, root.left);
    preOrder_Array_Helper(pre, root.right);

}