class Node implements iNode
{
  private List<iNode> childNodes;
  private int maxChildren;
  ...

  public Node(int maxChildren)
  {
    this.maxChildren = maxChildren;
    this.childNodes = new ArrayList<iNode>();
  }

  public void addChildNode(iNode child) throws SomeCustomException
  {
    if (childNodes.size() < maxChildren) {
      childNodes.add(child);
    } else {
      throw new SomeCustomException();
    }
  }
}