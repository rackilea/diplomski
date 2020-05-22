public boolean searchNum(BinTreeNode node, int num) {
    //validate the input
    if(node == null) {
        return false;
    }
    //this is your terminal case
    int result = num - node.item;
    //I have a separate find() which finds if the key is in the tree
    if(find(result)) {
        return true; 
    }
    //here is where we are returning the value we get back from searchNum
    return seachNum(node.leftChild, num) || searchNum(node.rightChilde, num);
}