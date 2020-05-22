String xmlString = ...
DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
Document doc = docBuilder.parse(xmlString);

XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
String xpathExp = "/books/book[@id=\"2\"]";
Node node = (Node) xpath.evaluate(xpathExp, doc, XPathConstants.NODE);