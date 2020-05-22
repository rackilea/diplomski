public void removeMax(BinaryTreeNode t) {
    if(t==null) return;
    BinaryTreeNode max = findMaxNode(t);
    //removing a node from its parent
    BinaryTreeNode parent = max.parent;
    if(parent==null) {
         //figure out what to do is the maximum value is at the root
    } else if(parent.leftChild==max) {
         parent.leftChild = null;
    } else if(parent.rightChild==max) {
         parent.rightChild = null;
    }
}