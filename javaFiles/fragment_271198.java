// retrieve <sentence> as Node, not as text
Node sentence = (Node) xPath.evaluate("sentence", transUnitElement, XPathConstants.NODE);

StringBuilder resultBuilder = new StringBuilder();
NodeList children = sentence.getChildNodes();

for (int i = 0; i < children.getLength(); i++) {
  Node child = children.item(i);
  short nodeType = child.getNodeType();
  switch (nodeType) {
    case Node.TEXT_NODE:
      String text = child.getTextContent().trim();
      resultBuilder.append(text);
      break;
    case Node.ELEMENT_NODE:
      String id = ((Element) child).getAttribute("id");
      resultBuilder.append(" {").append(id).append("} ");
      break;
    default:
      throw new IllegalStateException("Unexpected node type: " + nodeType);
  }
}
// outputs "first part of the text {interpolation_1} second part of the text {interpolation_2}"
System.out.println(resultBuilder.toString());