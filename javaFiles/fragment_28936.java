try {
  final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("input.xml");
  final XPathExpression xpath = XPathFactory.newInstance().newXPath().compile("//*[count(./*) = 0]");
  final NodeList nodeList = (NodeList) xpath.evaluate(doc, XPathConstants.NODESET);
  for(int i = 0; i < nodeList.getLength(); i++) {
    final Element el = (Element) nodeList.item(i);
    System.out.println(el.getNodeName());
  }
} catch (Exception e) {
  e.printStackTrace();
}