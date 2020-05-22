.....
String path = "/Textbook/TEXT[Title='" + elementName + "']/" + language
XPathExpression expr = xpath.compile(path);
NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
for (int i = 0; i < nodes.getLength(); i++) {
    return nodes.item(i).getTextContent();
}
.....