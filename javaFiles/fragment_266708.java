private Node getNodeAt(Node currentNode, int givenPosition) {
    if (givenPosition == 0){
        return currentNode;
    }else {
        return getNodeAt(currentNode.next, givenPosition - 1);
    }
}