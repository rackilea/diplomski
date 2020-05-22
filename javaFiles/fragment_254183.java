class Node {
  Integer value;
  Node[] children;
  Node(Node[] ...children) { this.children = children; }
  Node(Integer value) { this.value = value; }
}