public void inOrderTraverseBST(TreeNode root) {
    if (root == null) {
        return;
    }
    this.inOrderTraverseBST(root.leftChild);
    root.position = this.count++;
    this.inOrderTraverseBST(root.rightChild);
}