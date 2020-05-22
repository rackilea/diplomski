if (node.getNodeType() == Node.ELEMENT_NODE) {
    System.out.println(i);
    Element elem = (Element) node;

    // Get the value of the ID attribute.
    // String ID =
    // node.getAttributes().getNamedItem("ID").getNodeValue();

    // Get the value of all sub-elements.
    NodeList nameNodes = elem.getElementsByTagName("Name");
    for(int j = 0; j < nameNodes.getLength(); j++) {
        Node nameNode = nameNodes.item(j);
        staffList.add(new staff(nameNode.getTextContent()));
    }

    NodeList speedNodes = elem.getElementsByTagName("Speed");
    for(int j = 0; j < speedNodes.getLength(); j++) {
        Node speedNode = speedNodes.item(j);
        connectList.add(new connect(Integer.parseInt(speedNode.getTextContent())));
    }
}