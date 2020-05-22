XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xPath = xPathFactory.newXPath();
XPathExpression xPathExpression = xPath.compile("//listOfDocs//document/topic");

NodeList topicnl = (NodeList) xPathExpression.evaluate(dom, XPathConstants.NODESET);
for(int i = 0; i < topicnl.getLength(); i++) {
   ...