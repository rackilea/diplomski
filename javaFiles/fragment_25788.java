Node search(TreeNode root, int key){
    if (root == null)
        return null;

    if (root.data == key)
        return root;

    Node n;

    n = search(root.left, key);
    if (n != null)
        return n;

    n = search(root.right, key);
    if (n != null)
        return n;

    return null;
}