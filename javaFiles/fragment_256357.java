public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document dom = db.parse("country.xml");
    Element elem = dom.getDocumentElement();        
    int level = 1;
    System.out.println(elem.getNodeName() + "--->" + level);
    NodeList nl = elem.getChildNodes();
    displayLevel(nl,level);
}

/**
 * Recursive function to go through the nodes to display the level.
 * @param nl
 * @param level
 */
private static void displayLevel(NodeList nl, int level) {      
    level++;        
    if(nl != null && nl.getLength() > 0){
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            System.out.println(n.getNodeName() + "--->" + level);               
            displayLevel(n.getChildNodes(), level);             
        }
    }else{
        return;
    }

}