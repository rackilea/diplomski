XPathFactory factory = XPathFactory.newInstance();
XPath xPath = factory.newXPath();
NodeList nodeList = (NodeList) xPath.evaluate("//shoes/additional", new InputSource(new StringReader(xml)), XPathConstants.NODESET);
for (int i = 0; i < nodeList.getLength(); ++i) {
    String name = nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
    String text = nodeList.item(i).getTextContent();
    System.out.println(name + ", " + text);
}