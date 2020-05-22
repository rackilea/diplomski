@Override
public String toString() {
  final StringBuilder string = new StringBuilder();
  Node node = this.head;
  while (node != null) {
    string.append(node.item).append(' ');
    node = node.next;
  }
  // remove last space:
  if (string.length() > 0)
    string.setLength(string.length() - 1);
  return string.toString();
}