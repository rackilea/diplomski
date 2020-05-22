public void testXpathExpr(){

String testXML = "<sitemesh><mapping path=\"/editor/tempPage/**\" exclude=\"true\"/><mapping decorator=\"/WEB-INF/views/decorators/detailstheme.jsp\" path=\"/*\" exclude=\"false\" /></sitemesh>";

NodeList nodeList = getNodeList(testXML);
}

private NodeList getNodeList(String xml) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
  DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
  DocumentBuilder builder = docFactory.newDocumentBuilder();

  document = builder.parse(new ByteArrayInputStream( xml.getBytes() ) );
  XPathExpression exprPath = xpath.compile(xpathExpr);
  NodeList nodeList = (NodeList) exprPath.evaluate(document, XPathConstants.NODESET);;
return nodeList;
}