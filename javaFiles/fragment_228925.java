StringBuilder concatenated = new StringBuilder():
XPath xpath = XPathFactory.newInstance().newXPath();
String expression = "/test/nodeA/nodeC/text()";
InputSource inputSource = new InputSource("sample.xml");
NodeList nodes = (NodeList) xpath.evaluate(expression, inputSource, XPathConstants.NODESET);
for(int i = 0; i < nodes.getLength(); i++) {
    concatenated.append(nodes.item(i).getTextContent());
}