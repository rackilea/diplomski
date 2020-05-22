class SpecialNode<T extends Comparable<T>> extends DefaultMutableTreeNode 
                                          implements Comparable<SpecialNode>
{
  T typedUserObject;
  SpecialNode(T t)
  {
     this.typedUserObject = t;
     setUserObject(t);
  }


  public int compareTo(SpecialNode node)
  {
      if(typedUserObject.getClass().isInstance(node.typedUserObject))
      {
          T otherObj = (T) node.typedUserObject;
          return typedUserObject.compareTo(otherObj);
      }
      else
      {
          //What are you going to do if they're not the same type?
          return -1;
      }
  }


}