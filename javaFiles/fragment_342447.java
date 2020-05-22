NodeList nodeList = (NodeList)xPath1.compile("/place/native[@name]").evaluate(xmlDocument, XPathConstants.NODESET);
String[] results = new String[nodeList.getLength()];
for (int index = 0; index < nodeList.getLength(); index++) {
    Node node = nodeList.item(index);
    String name = node.getAttributes().getNamedItem("name");
    results[index] = name;
}