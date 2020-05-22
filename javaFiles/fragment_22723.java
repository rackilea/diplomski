public void inOrder(TreeNode node, E[] array, int index){
    if(node == null){  // recursion anchor: when the node is null an empty leaf was reached (doesn't matter if it is left or right, just end the method call
       return;
    }
    inOrder(node.getLeft(), array, index);   // first do every left child tree
    array[index++]= node.getData();          // then write the data in the array
    inOrder(node.getRight(), array, index);  // do the same with the right child
}