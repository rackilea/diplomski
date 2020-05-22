/**
 * Recursively updates heights starting with given node. 
 * If height of given node is already correct we know 
 * that we can stop.
 */
private void updateHeights(AvlNode<T> node){
    if(node == null) return;
    int heightLeft = node.left != null ? node.left.height : -1;
    int heightRight = node.right != null ? node.right.height : -1;
    int height = heightLeft > heightRight ? heightLeft + 1 : heightRight + 1;
    if(node.height != height){
        node.height = height;
        updateHeights(node.parent);
    }
}