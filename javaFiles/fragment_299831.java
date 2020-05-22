public boolean insert(E e) {        
    if (root == null) {
        root = new BTNode();
        root.setElement(e); //how would this work with a null root?
        return true; //that's it, we're done (when is this ever false by the way?)
    }
    BTNode current = root; 
    while (true) { //brackets! indenting is important for readabilty
        BTNode parent=current;
        if (current.element().getClass().getName().compareTo(e.getClass().getName()) < 0) {
            current = current.getRight();
            if(current==null) { //we don't have a right node, need to make one
              current = new BTNode();
              parent.setRight(current);
              break; //we have a new node in "current" that is empty
            }
        } else { 
            current= current.getLeft();
            if(current==null) { //we don't have a left node, need to make one
              current = new BTNode();
              parent.setLeft(current);
              break;  //we have a new node in "current" that is empty
            }
        }
    }
    current.setElement(e); 
    return true; 
}