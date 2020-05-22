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
    //this if doesn't make any sense as you validate this input already
    //if(node.leftChild != null) {
    //    searchNum(node.leftChild, num);
    //}
    //here is where we are returning the value we get back from searchNum
    return seachNum(node.leftChild, num) || searchNum(node.rightChilde, num);
    //System.out.println(node.item);
    //I moved this up into the single return case, so everything after this is unnecessary
    //if(node.rightChild != null) {
    //    searchNum(node.rightChild, num);
    //} 
    //return false;
}