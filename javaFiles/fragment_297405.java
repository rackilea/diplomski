int size(Node node){
    if(node==null){
        return 0;
    }
    return (1 + size(node.left) + size(node.right));
}