boolean isLeaf(BTNode node, int data) {
    if (node == null)
        return false;    
    if (node.right == null && node.left == null)
        return true;
    return false; 
}