public void insert(int item) {
    Queue<TreeNode> q = new LinkedList<TreeNode>();

    if(root==null){
        root = new TreeNode(item);
    } else {
        temp = root;
        q.offer(temp);
        while (!q.isEmpty()) {
            temp = q.peek();
            if (temp.left == null) {
                temp.left = new TreeNode(item);
                break;
            }
            if (temp.right == null) {
                temp.right = new TreeNode(item);
                break;
            } else{
                q.offer(temp.left);
                q.offer(temp.right);
                q.poll();
            }
        }
    }
}