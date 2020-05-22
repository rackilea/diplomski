public T FindSmallest(BinaryNode Node){ 
  if (Node == null) 
    return null;

  if(Node.getLeftChild()==null) 
    return Node.getData(); 

  return findSmallest(Node.getLeftChild()); 
}