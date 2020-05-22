public static void main(String argv[]) {
        try {

               File fXmlFile = new File("c:\\file.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root element :"
                + doc.getDocumentElement().getNodeName());
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr = xpath.compile("//hotels/e");
        NodeList nList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("-----------------------");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Hotel Name : "
                        + getTagValue("name", eElement));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();

    }