/**
 * Serializes a XML node to a string representation without XML declaration
 * 
 * @param node The XML node
 * @return The string representation
 * @throws TransformerFactoryConfigurationError
 * @throws TransformerException
 */
private static String node2String(Node node) throws TransformerFactoryConfigurationError, TransformerException {
  final Transformer transformer = TransformerFactory.newInstance().newTransformer();
  transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
  final StringWriter writer = new StringWriter();
  transformer.transform(new DOMSource(node), new StreamResult(writer));
  return writer.toString();
}

/**
 * Serializes the inner (child) nodes of a XML element.
 * @param el
 * @return
 * @throws TransformerFactoryConfigurationError
 * @throws TransformerException
 */
private static String elementInner2String(Element el) throws TransformerFactoryConfigurationError, TransformerException {
  final NodeList children = el.getChildNodes();
  final StringBuilder sb = new StringBuilder();
  for(int i = 0; i < children.getLength(); i++) {
    final Node child = children.item(i);
    sb.append(node2String(child));
  }
  return sb.toString();
}