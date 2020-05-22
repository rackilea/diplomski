Node next;

public boolean hasNext() {
   //if the next value already known, do nothing
   if (next==null) {         
     //otherwise lookup the next value
     next=findNext();
   }
   //return true if the next value was found
   return next!=null;
}

public Node next() {
  if (next==null&&!hasNext()) {
     //here we have reached the end of the iteration
     throw new NoSuchElementException();
  } else {
     //either we alredy knowed the next element 
     //or it was found by hasNext
     Node result = next;
     next=null;
     return result;
  }   
}

private Node findNext() {
   //the actual iteration
}