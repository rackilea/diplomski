private int deleter(BSTNode node, int key) {
    if(node.key == key){
        if(node.right == null && node.left == null){
            node = null;
            return 0;
        }
    }else if(key < node.key){
        node = node.left;
        return deleter(node,key);      // return here    
    }else {
        node = node.right;
        return deleter(node,key);      // return here
    }   
    return -1;
}