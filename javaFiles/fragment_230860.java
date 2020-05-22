public static String findXPathInXMLString(int index, String string) throws XPathExpressionException, SAXException, ParserConfigurationException, IOException {
    String xpath;

    //Step 1. Insert temporary tag in insert location
    StringBuilder stringBuilder = new StringBuilder(string);
    stringBuilder.insert(index, "<findXPathInXMLStringTemporaryTag />");

    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
        new ByteArrayInputStream(stringBuilder.toString().getBytes())
      );

    //Step 2. Convert string document to DOM document & Find XPath of temporary tag in DOM document
    xpath = getXPath(document, "findXPathInXMLStringTemporaryTag");

    //Step 3. Cut off last part of the XPath
    xpath = xpath.replace("/findXPathInXMLStringTemporaryTag", "");

    //Step 4. Return the XPath
    return xpath;
}

private static String getXPath(Document root, String elementName) throws XPathExpressionException 
{
  XPathExpression expr = XPathFactory.newInstance().newXPath().compile("//"+elementName);
  Node node = (Node)expr.evaluate(root, XPathConstants.NODE);


  if(node != null) {
      return getXPath(node);
  }

  return null;
}

private static String getXPath(Node node) throws XPathExpressionException {
    if(node == null || node.getNodeType() != Node.ELEMENT_NODE) {
        return "";
    }

    return getXPath(node.getParentNode()) + "/" + node.getNodeName() + getIndex(node);
}

private static String getIndex(Node node) throws XPathExpressionException {
    XPathExpression expr = XPathFactory.newInstance().newXPath().compile("count(preceding-sibling::*[local-name() = '" + node.getNodeName() + "'])");
    int result = (int)(double)(Double)expr.evaluate(node, XPathConstants.NUMBER);

    if(result == 0){
        return "";
    }
    else {
        return "[" + (result + 1) + "]";
    }
}