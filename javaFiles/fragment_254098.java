public static String processLinks(String rssFeed) throws Exception {
  DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder = docFactory.newDocumentBuilder();
  Document doc = builder.parse(new InputSource(new StringReader(rssFeed)));

  NodeList nodeList = doc.getElementsByTagName("link");
  for (int i = 0; i < nodeList.getLength(); i++) {
    Node link = nodeList.item(i);
    String value = link.getTextContent();
    //Do the processing. For example:
    if(!value.startsWith("http://")) {
      link.setTextContent("http://"+value);
    }
  }
  return toString(doc);
}

private static String toString(Document doc) throws Exception {
  TransformerFactory tf = TransformerFactory.newInstance();
  Transformer transformer = tf.newTransformer();
  transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
  StringWriter writer = new StringWriter();
  transformer.transform(new DOMSource(doc), new StreamResult(writer));
  return writer.toString();
}