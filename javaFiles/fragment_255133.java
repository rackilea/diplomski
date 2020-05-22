public void deleteNode(Node node) {           
    if (node.getParent().left().root == node) {//this is where you get NullPointerException
        node.getParent().setLeft(null);
    } else {
        node.getParent().setRight(null);
    }
}