public static void main(String arg[]) throws ParserConfigurationException,
        SAXException, IOException {
    File xmlFile = new File("votes.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(xmlFile);

    doc.getDocumentElement().normalize();

    NodeList serviceNodeList = doc.getElementsByTagName("city"); 

    for (int servicenodeCount = 0; servicenodeCount < serviceNodeList.getLength(); servicenodeCount++) {
        Node servicenode = serviceNodeList.item(servicenodeCount);
        if (servicenode.getNodeType() == Node.ELEMENT_NODE) {
            Element singleServiceNode = (Element) servicenode;
            NodeList functionNodeList = singleServiceNode.getElementsByTagName("party_votes");

            System.out.println("City  : " + singleServiceNode.getAttribute("id"));

            for(int functionNodeCount = 0; functionNodeCount < functionNodeList.getLength();functionNodeCount++){
                 Node functionNode = functionNodeList.item(functionNodeCount);                      
                 if (functionNode.getNodeType() == Node.ELEMENT_NODE) {
                     Element singleFunctionNode = (Element) servicenode;
                     NodeList mappingNodeList = singleFunctionNode.getElementsByTagName("party");

                     System.out.println("Total Seats : " + singleFunctionNode.getElementsByTagName("total_seats").item(0).getTextContent());

                     for(int genericNodeCount = 0; genericNodeCount < mappingNodeList.getLength();genericNodeCount++){
                         Node genericNode = mappingNodeList.item(genericNodeCount);
                         if (genericNode.getNodeType() == Node.ELEMENT_NODE) {
                             Element singleGenericElement = (Element) genericNode;
                            System.out.println("Party : " + singleGenericElement.getAttribute("id"));
                            System.out.println("First Name : " + singleGenericElement.getElementsByTagName("total_votes").item(0).getTextContent());
                         }
                     }
                 }
            }
        }
    }
}