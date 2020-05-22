private static int preOrder_Array_Helper(int[] pre, BinaryTreeNode<Integer> root, int index) {
    if (root == null)
        return index;        //return the same as get

    pre[index] = root.data;
    index++; 
    if (index == pre.length) {
        return index;  //return new value after add
    } else {  
        index = preOrder_Array_Helper(pre, root.left, index);  //get last after left branch visit
        return preOrder_Array_Helper(pre, root.right, index); //use new index in right branch
    }
}