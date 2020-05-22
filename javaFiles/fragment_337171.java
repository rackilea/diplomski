final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
final XPathExpression expression = XPathFactory.newInstance().newXPath().compile("//stock");
final NodeList nodeList = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
for (int i = 0; i < nodeList.getLength(); ++i) {
    final NodeList childList = ((Element) nodeList.item(i)).getChildNodes();
    for (int j = 0; j < childList.getLength(); ++j) {
        final Node node = childList.item(j);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(node.getNodeName() + "=" + node.getTextContent());
        }
    }
}