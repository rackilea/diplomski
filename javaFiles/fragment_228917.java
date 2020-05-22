public static void swap(TreeNode a, TreeNode b) {
    String tempValue = a.value;
    a.value = b.value;
    b.value = tempValue;

    int tempIndex = a.index;
    a.index = b.index;
    b.index = tempIndex;

    TreeNode tempNode = a.parent;
    a.parent = b.parent;
    b.parent = tempNode; 

    tempNode = a.leftChild;
    a.leftChild = b.leftChild;
    b.leftChild = tempNode;    

    tempNode = a.rightChild;
    a.rightChild = b.rightChild;
    b.rightChild = tempNode;    
}