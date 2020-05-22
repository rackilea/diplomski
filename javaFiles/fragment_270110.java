private static List<Element> getValueElementsUsingXpath(Document document) throws XPathExpressionException {
  XPath xpath = XPathFactory.newInstance().newXPath();
  // XPath Query for showing all nodes value
  XPathExpression expr = xpath.compile("//property/value");
  Object xpathResult = expr.evaluate(document, XPathConstants.NODESET);

  List<Element> result = new ArrayList<Element>();
  NodeList nodes = (NodeList) xpathResult;
  for (int i = 0; i < nodes.getLength(); i++) {
    Node valueNode = nodes.item(i);
    if (!(valueNode instanceof Element)) continue;
    result.add((Element) valueNode);
  }

  return result;
}