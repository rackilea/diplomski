public static void toOrderListFromXML() throws ParserConfigurationException, 
    SAXException, IOException {
        File fXmlFile = new File("test.xml");

        DocumentBuilderFactory dbFactory = 
   DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);

    doc.getDocumentElement().normalize();

    System.out.println("Root element :" + 
   doc.getDocumentElement().getNodeName());

    NodeList nList = doc.getElementsByTagName("string");

    for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);

        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;

            System.out.println("Order number: " + 
          eElement.getTextContent());
         }
     }
   }
 }