Index<Node> nameIndex = graphDb.index().forNodes("names");

public Node getOrCreateNode(String name) {
  Node found = nameIndex.get("name",name).getSingle();
  if (found!=null) return found;
  Node nameNode = graphDb.createNode();
  nameNode.setProperty("name",name);
  nameIndex.add(nameNode, "name", name);
  return nameNode;
}