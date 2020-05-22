private BinaryNode<T> findElementNode(T element, BinaryNode<T> start) {
    if(start != null){
        if(start.getElement().equals(element)){
           return start;
        } else {
            BinaryNode<T> start = findElementNode(element, start.getLeftChild());
            if(start == null) {
                start = findElementNode(element, start.getRightChild());
            }
            return start;
         }
    } else {
        return null;
    }
}