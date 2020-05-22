public void parseTags (String indentLevel, Node node) {
  //print out node-specific items at indentLevel
  String childIndent = indentLevel + "\t";

  for (Node n : /*whatever nodes you're recursing to*/) {
    parseTags(childIndent, n);
  }
}