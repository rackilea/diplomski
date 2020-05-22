List<Node> out = new ArrayList<Node>();
while (currentNode != null) {
   out.add(currentNode.node);
   currentNode = currentNode.parentNode;
}
return out;