class NodeWrapper {
 public float cost;
 public Node node;
 public Node parentNode;
 public NodeWrapper(Node node, Node parentNode) {
   this.node = node;
   this.parentNode = parentNode;
 }
}