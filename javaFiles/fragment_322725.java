private boolean find(int key, BinTreeNode node) {
    if (node == null) {
        return false;
    }    
    if(key == node.item) {
        return true;
    }
    else if(key < node.item) {
        return findHelper(key,node.leftChild);
    }
    else {
        return findHelper(key,node.rightChild);
    }
}