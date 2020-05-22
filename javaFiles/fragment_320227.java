boolean isLeaf(BTNode node, int data) {
    if (node == null)       
        return false;
    if (node.left == null && node.right == null)      
        return true; 
    isLeaf(node.left); 
    isLeaf(node.right);      
}