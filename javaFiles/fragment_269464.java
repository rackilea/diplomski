public class Node
{
  private int nodeId;
  private List<Connection> outboundConnections = new ArrayList<>();

  public Node(int nodeId)
  {
    this.nodeId = nodeId;
  }

  public void addConnection(Connection connection)
  {
    this.outboundConnections.add(connection);
  }

  //... setters and getters
}