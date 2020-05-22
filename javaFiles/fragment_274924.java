DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(XML_FILE_URI);

XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile("/temperature[@type='hourly']/value/text()");

NodeList result = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
for (int i = 0; i < result.getLength(); i++) {
    System.out.println(result.item(i).getNodeValue());
}