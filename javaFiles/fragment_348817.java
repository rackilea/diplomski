private String xPathValue(String path) {
    XPath myPath = XPathFactory.newInstance().newXPath();
    XPathExpression expr =  xpath.compile(path);  
    String result = (String)expr.evaluate(myDoc, XPathConstants.STRING);  

    return result;
}