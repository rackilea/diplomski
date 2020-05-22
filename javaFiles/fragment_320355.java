System.out.println("Root element: " + document.getDocumentElement().getNodeName());
NodeList nodeList = document.getElementsByTagName("parameter");
for (int temp = 0; temp < nodeList.getLength(); temp++) {
    org.w3c.dom.Node node = nodeList.item(temp);
    System.out.println("\nCurrent element: " + node.getNodeName());
    if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
        Element element = (Element) node;
        System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
        System.out.println("Key Value: " + element.getElementsByTagName("keyvalue").item(0).getTextContent());
    }
}