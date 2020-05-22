public void createTree(TreeNode tree) throws IOException {
    // Check that index is not out of bounds first
    if (i >= preorder.length) {
        i++;
    } else if (preorder[i] == '0') {
        tree.value = '0';
        tree.left = tree.right = null;
        i++;                
    } else {
        tree.value = preorder[i];   
        i++;
        tree.left = new TreeNode();
        createTree(tree.left);
        tree.right = new TreeNode();
        createTree(tree.right);
    }
}