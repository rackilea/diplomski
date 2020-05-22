Set<String> uniqueAuthors = new HashSet<String>();
XPathFactory factory = XPathFactory.newInstance();
XPath xPath = factory.newXPath();
XPathExpression expr = xpath.compile("//book/author/text()");
NodeList nodes = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);
for (int i = 0; i < nodes.getLength(); ++i) {
    uniqueAuthors.add(nodes.item(i).getNodeValue());
}