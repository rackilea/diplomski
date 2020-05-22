int cal(Node node){
    int left = cal(node.left);
    int right = cal(node.right);
    left[node.index] = left;
    right[node.index] = right;
    //Depend on the current node have left or right node, we add 0,1 or 2 to the final result
    int add = (node.left != null && node.right != null)? 2 : node.left != null ? 1 : node.right != null ? 1 : 0;
    return left + right + add;
}