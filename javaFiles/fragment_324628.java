public static void main(String argv[]) {

    try {

        File fXmlFile = new File("//test.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("doc");
        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("First Name : " + eElement.getElementsByTagName("field").item(0).getTextContent());
                System.out.println("Date : " + eElement.getElementsByTagName("field").item(1).getTextContent());
                System.out.println("Text : " + eElement.getElementsByTagName("field").item(2).getTextContent());

            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}