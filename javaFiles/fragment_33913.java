public int depthSum(IntTreeNode root) {
    if(root == null) throw new NullPointerException();

    Queue<IntTreeNode> q = new LinkedList<IntTreeNode>();
    q.add(root);
    int siblings = 1;
    int totalSum = 0, levelSum = 0, level = 0;

    while(!q.isEmpty()) {
        IntTreeNode n = q.remove();            // Only remove one node per loop
        levelSum += n.data;

        if(n.left != null)                     // Add left child 
            q.add(n.left);

        if(n.right != null)                    // Add right child
            q.add(n.right);

        if(--siblings == 0){                   // All siblings have been probed
            siblings = q.size();               // All remaining Nodes are siblings
            totalSum += levelSum * level;      // increment totalSum
            level++;                           // increment level
            levelSum = 0;                      // reinitialize levelSum
        }
    }
    return totalSum;
}