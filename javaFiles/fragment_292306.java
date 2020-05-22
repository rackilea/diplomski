public void xmlParse(String xmlFile) throws ParserConfigurationException, SAXException,IOException {
    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    Document document = docBuilder.parse(new File(xmlFile));
    xmlParse(document.getDocumentElement());
}

private void xmlParse(Element node) {
    NodeList nodeList = node.getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node currentNode = nodeList.item(i);
        String value = currentNode.getNodeName();
        System.out.print(value + " "); // prints Employee

        NodeList nodes = currentNode.getChildNodes();
        for (int j = 0; j < nodes.getLength(); j++) {
            Node cnode = nodes.item(j);
            System.out.print(cnode.getNodeName() + " ");//prints:name, id, age
        }
        System.out.println();
    }
}