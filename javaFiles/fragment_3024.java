File xmlFile = new File("your_xml.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(xmlFile);

NodeList nList = doc.getElementsByTagName("offset");
for (int i = 0; i < nList.getLength(); i++) {
    Node node = nList.item(i);
    node.getParentNode().removeChild(node); 
}