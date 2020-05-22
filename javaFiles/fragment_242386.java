public ArrayList<String> readXML(String xmlString, String elementName,
        String textContent) {
    ArrayList<String> resultValues = new ArrayList<String>();
    try {
        boolean elementNameFlag = false, nodenameFlag = false;

        DocumentBuilder dbFactory = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder();

        InputSource is = new InputSource();

        is.setCharacterStream(new StringReader(xmlString));

        Document doc = dbFactory.parse(is);

        NodeList list = doc.getElementsByTagName("*");

        String rootNodeName = doc.getDocumentElement().getNodeName();

        if (elementName == rootNodeName || textContent == rootNodeName) {
            gl.writeWarning("elementName or nodeName should not be root name");
        } else {

            for (int i = 0; i < list.getLength(); i++) {

                Element element = (Element) list.item(i);
                if (elementName == element.getNodeName()) {
                    elementNameFlag = true;
                }

                if (textContent == element.getNodeName()) {
                    nodenameFlag = true;
                }
            }


            if (elementNameFlag == nodenameFlag) {

                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName(elementName);

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;

                        resultValues
                                .add(getTagValue(textContent, eElement));
                    }
                }
            } else {

            }
        }
    } catch (Exception e) {

        e.printStackTrace();
    }
    return resultValues;
}// readXML()