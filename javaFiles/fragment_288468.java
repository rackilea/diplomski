public class Node {
  private final int value;
  private final List<Node> children;

  public Node(int value) {
    this.value = value;
    this.children = new LinkedList<Node>();
  }

  public int getValue() {
    return value;
  }

  public List<? extends Node> getChildren() {
    return Collections.unmodifiableList(children);
  }

  public void addChild(Node child) { 
    children.add(child);
  }
}