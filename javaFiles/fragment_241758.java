// parse the XML as a W3C Document
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
org.w3c.Document document = builder.parse(new File("/widgets.xml"));
// evaluate the XPath expression against the Document
XPath xpath = XPathFactory.newInstance().newXPath();
String expression = "/widgets/widget[@name='a']/@quantity";
Double quantity = (Double) xpath.evaluate(expression, document, XPathConstants.NUMBER);