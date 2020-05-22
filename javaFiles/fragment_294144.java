InputSource stream = new InputSource(inputStream);
XPath xpath = XPathFactory.newInstance().newXPath();
Document doc = (Document) xpath.evaluate("/", stream, XPathConstants.NODE);

NodeList nodes = (NodeList) xpath.evaluate("//text()", doc,
    XPathConstants.NODESET);
for (int i = 0; i < nodes.getLength(); i++) {
  Text text = (Text) nodes.item(i);
  text.setTextContent(text.getTextContent().replaceAll("\\s{2,}", " "));
}

// check results
TransformerFactory.newInstance()
    .newTransformer()
    .transform(new DOMSource(doc), new StreamResult(System.out));