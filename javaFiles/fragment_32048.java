File fXmlFile = new File("your XML file");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);

doc.getDocumentElement().normalize();

System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

NodeList nList = doc.getElementsByTagName("Cube");

System.out.println("----------------------------");

for (int temp = 0; temp < nList.getLength(); temp++) {

    Node nNode = nList.item(temp);

    System.out.println("\nCurrent Element :" + nNode.getNodeName());


    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        Element eElement = (Element) nNode;
        String currency = eElement.getAttribute("currency");
        String rate = eElement.getAttribute("rate");
        if(currency.isEmpty()){
            continue;
        }
        System.out.println("Ccurrency :" + currency);
        System.out.println("Rate : " + rate); 
    }
}