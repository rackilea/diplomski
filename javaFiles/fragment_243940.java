public class NodeWrapper implements Comparable<NodeWrapper> {
  private static AtomicLong serialNumGenerator = new AtomicLong(0L);

  private final Node node;
  private final long serialNum;

  public NodeWrapper(Node node) {
    this.node = node;
    this.serialNum = serialNumGenerator.getAndIncrement();
  }

  @Override
  public int compareTo(NodeWrapper other) {
    int compare = this.node.compareTo(other.node);
    if (compare == 0) {
      compare = (this.serialNum < other.serialNum)
          ? -1
          : ((this.serialNum > other.serialNum) ? 1 : 0);
    }
    return compare;
  }
  // implement other methods including equals() and hashCode()
}