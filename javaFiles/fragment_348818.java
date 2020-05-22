private String xPathValue(String path) {
    XPath myPath = XPathFactory.newInstance().newXPath();
    XPathExpression expr =  xpath.compile(path);  
    Node result = (Node)expr.evaluate(myDoc, XPathConstants.NODE);  

    return result.getTextContent();
}