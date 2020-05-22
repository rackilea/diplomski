// returns true if the element has been added to this subtree
public boolean addLeft(E elem, E parentVal) {
    if (this.equals(parentVal)) {
        //Create node with element elem (call it newNode)
        //Set the left child of the node with parentVal as newNode
        return true;
    } else if (leftChild != null && leftChild.addLeft(elem, parentVal)) {
        return true;
    } else {
        return rightChild != null && rightChild.addLeft(elem, parentVal);
    }
}