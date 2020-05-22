public static boolean everything1(IntBTNode root) {
    if (root == null) {
        return true;
    } else {
        return (root.data == 1) && everything1(node.left) && everything1(root.right)
    }
}