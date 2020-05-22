class MyTreeNode implements MutableTreeNode
{
  UserObject yourObject;

  MyTreeNode(UserObject yourObject)
  {
    this.yourObject = yourObject;
  }

  // implement all needed methods to handle children and so on

  public String toString()
  {
    // then you can avoid using toString
    return yourObject.sringRapresentation();
  }
}