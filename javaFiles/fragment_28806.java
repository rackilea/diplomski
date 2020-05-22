public static String getMessageType(Document xml) {
    try {
        xpathFactory = XPathFactory.newInstance(NamespaceConstant.OBJECT_MODEL_SAXON);
        XPath xpath = xpathFactory.newXPath();


        XPathExpression searchRequest = xpath.compile("//*[ends-with(name(),'Request')]");
        XPathExpression searchResponse = xpath.compile("//*[ends-with(name(),'Response')]");
        NodeList requestResult = (NodeList) searchRequest.evaluate(xml, XPathConstants.NODESET);
        NodeList responseResult = (NodeList) searchResponse.evaluate(xml, XPathConstants.NODESET);

        if(requestResult.getLength() != 0) return "REQ";
        if(responseResult.getLength() != 0) return "RESP";
    } catch (XPathExpressionException e) {
        e.printStackTrace();
        return null;
    } catch (XPathFactoryConfigurationException e) {
        e.printStackTrace();
        return null;
    }
}