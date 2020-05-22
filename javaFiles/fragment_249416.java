public LinkedList<TreeNode<T>> createTree() {
    //Root TreeNode
    TreeNode<T> root = new TreeNode<T>(data, null);

    //TreeNode on which we currently operate
    TreeNode<T> current;
    //List of treenodes holding the result
    List<TreeNode<T>> treeList = new LinkedList<TreeNode<T>>();
    //Queue holding the nodes for which we will create 26 children elements
    Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
    treeList.add(root);
    queue.add(root);

    for (int i=0; i< (some number); i++) {
    current = queue.remove();
    child = new TreeNode<T>>(data, current);
    current.addChild(child);
    queue.add(child);
    treelist.add(child);
    }
    return treeList;

}