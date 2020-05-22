XPathFactory xfactory = XPathFactory.newInstance();
XPath xpathObj = xfactory.newXPath();
Node node;

try {
    node = (Node)xpathObj.evaluate(xpath, doc, XPathConstants.NODE);
} catch (XPathExpressionException e) {
    throw new RuntimeException(e);
}

node.setTextContent(elementValue);