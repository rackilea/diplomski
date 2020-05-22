class TreeNode {
    int content;
    TreeNode left;
    TreeNode right;

    public TreeNode(int content, TreeNode left, TreeNode right) {
        this.content = content;
        this.left = left;
        this.right = right;
    }

    public void setContent(int content) {
        synchronized (this) {
            this.content = content;
        }
    }
}