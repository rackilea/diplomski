public ModifyXmlFile setElementAttributeValue(String nodeXPath, String attributeName, String newAttributeValue) throws XPathExpressionException{

    try {
        XPath xPath = XPathFactory.newInstance().newXPath();
        Node node = (Node)xPath.evaluate(nodeXPath,  _doc, XPathConstants.NODE);
        node.getAttributes().getNamedItem(attributeName).setNodeValue(String.format(CONNECTION_STRINGS, newAttributeValue));