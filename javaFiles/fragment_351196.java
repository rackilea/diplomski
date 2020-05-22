public void traverse (Node root){ // Each child of a tree is a root of its subtree.
    if (root.left != null){
        traverse (root.left);
    }
    System.out.println(root.data);
    if (root.right != null){
        traverse (root.right);
    }
}