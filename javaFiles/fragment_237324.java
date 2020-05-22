public T FindSmallest(BinarySearchTree<T> tree){ 
  BinaryNode Node = new BinaryNode(tree.getDataRoot());
  if (Node == null) 
    return null;

  while(Node.hasLeftChild()) 
    Node = Node.getLeftChild();

  return Node.getData(); 
}