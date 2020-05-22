File f = new File("your.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(f);

NodeList eList = doc.getElementsByTagName("*");
for (int e = 0; e < eList.getLength(); e++) {
    Node element = eList.item(e);
    NodeList nList = element.getChildNodes();
    for(int n = 0; n < nList.getLength(); n++){
        Node node = nList.item(n);
        if(node.getNodeType()==Node.TEXT_NODE){
            node.setNodeValue(node.getNodeValue().replace("x.y", "p.q")); 
        }
    }
}