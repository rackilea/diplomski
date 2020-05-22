public int countVal(int v) {
    if(root == null)
        return -1;
    else
        return countValRec(v, root);
}

private int countValRec(int v, Node node) {
    if(node == null)
        return 0;
    else if(node.key == v)
        return nodeCountValRec(v, node.left) + 1 + nodeCountValRec(v, node.right);
    else
        return nodeCountValRec(v, node.left) + nodeCountValRec(v, node.right);
}