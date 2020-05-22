class SpecialNode<T extends Comparable<T>> extends DefaultMutableTreeNode
                                          implements Comparable<SpecialNode<T>>
{
  T typedUserObject;
  SpecialNode(T t)
  {
     this.typedUserObject = t;
     setUserObject(t);
  }


  public int compareTo(SpecialNode<T> node)
  {
     return typedUserObject.compareTo(node.typedUserObject);
  }    
}