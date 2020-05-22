public int getHeight(BinaryTree node){
    if(node == null){
        return 0;
    }

    int left = getHeight(node.left);
    int right = getHeight(node.right);

    return Math.max(left, right) + 1;
}