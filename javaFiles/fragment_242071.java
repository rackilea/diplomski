private boolean findElementNode(T element, BinaryNode<T> start) {

    if (start == null) {
       return false;
    } else {
      if (element.getElement().equals(start.getElement())) {
         return true;
      } else {
         int comparison = element.compareTo(start.getElement());

         if (comparison < 0) {
            return findElementNode(element, start.getLeftChild());
         } else {
            return findElementNode(element, start.getRightChild());
         }          
     }
}