private String nodeToString(Node node) {
  StringWriter sw = new StringWriter();
  try {
    Transformer t = TransformerFactory.newInstance().newTransformer();
    t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    t.transform(new DOMSource(node), new StreamResult(sw));
  } catch (TransformerException te) {
    System.out.println("nodeToString Transformer Exception");
  }
  return sw.toString();
}