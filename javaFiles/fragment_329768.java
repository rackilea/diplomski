XPathFactory factory = XPathFactory.newInstance();
XPath path = factory.newXPath();
Node node = (Node) path.evaluate("//myXPath", document, XPathConstants.NODE);
if (node == null)
    // don't exists
else
    // I exist!