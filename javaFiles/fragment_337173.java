final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
final XPathExpression expression = XPathFactory.newInstance().newXPath().compile("//stock/*/text()");
final NodeList nodeList = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
for (int i = 0; i < nodeList.getLength(); ++i) {
    final Node node = nodeList.item(i);
    System.out.println(node.getNodeValue());
}