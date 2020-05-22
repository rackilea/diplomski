public static void main(String[] args) {

    try {

        File xmlFile = new File("TCMB2.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = documentBuilder.parse(xmlFile);

        NodeList list = doc.getElementsByTagName("Currency");


        for (int i = 0; i < list.getLength(); i++) {

            Node node = list.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Kod: " + element.getAttribute("Kod"));
                System.out.println("Para Birimi: " + element.getElementsByTagName("Isim").item(0).getTextContent());
                System.out.println("Forex Satis Ucreti: " + element.getElementsByTagName("ForexSelling").item(0).getTextContent()) ;

            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}