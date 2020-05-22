// Get all rounds and iterate over them
NodeList rounds = (NodeList) xpath.evaluate("//Round", doc, XPathConstants.NODESET);
for (Node round : rounds) {
  // Get all doors and iterate over them
  NodeList doors = (NodeList) xpath.evaluate("Door", round, XPathConstants.NODESET);
  for (Node door : doors) {
    // Get all values and iterate over them
    NodeList values = (NodeList) xpath.evaluate("Value/*/text()", door, XPathConstants.NODESET);
    for (Node value : values) {
      // Do something
    }
  }
}