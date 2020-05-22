NodeList cNodeList = root.getElementsByTagName("field");

for(int i = 0; i < cNodeList.getLength(); ++i) {
    Node cNode = cNodeList.item(i);
    Node dAttribute = cNode.getAttributes().getNamedItem("name");
    String nameValue = dAttribute.getNodeValue()
    System.out.println(nameValue);
}