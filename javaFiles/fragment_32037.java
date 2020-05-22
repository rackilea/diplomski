public void generateTree(ArrayList<Pair<String , Float>> vector){
    //todo holds all nodes that haven't yet had their children assigned
    ArrayList<TreeNode> todo = new ArrayList<>();
    todo.add(new TreeNode(vector.remove(0) , null , null));
    TreeNode root = todo.get(0);

    while(!todo.isEmpty() && !vector.isEmpty())
    {
        TreeNode node = todo.remove(0);

        if(node == null)
            continue;

        //generate the children for the current node
        TreeNode left = vector.get(0) == null ? null : new TreeNode(vector.get(0) , null , null);
        TreeNode right = vector.get(1) == null ? null : new TreeNode(vector.get(1) , null , null);

        vector.remove(0);
        vector.remove(0);

        node.leftNode = left;
        node.rightNode = right;

        //left and right haven't yet had their children assigned
        //queue them, so that they will be processed as soon as the
        //rest of the queue before them has been processed
        todo.add(left);
        todo.add(right);
    }
}