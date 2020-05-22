DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document dom = db.parse("file.xml");
    Element docEle = dom.getDocumentElement();
    NodeList nl = docEle.getChildNodes();
    int length = nl.getLength();
    for (int i = 0; i < length; i++) {
        if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
            Element el = (Element) nl.item(i);
            if (el.getNodeName().contains("staff")) {
                String name = el.getElementsByTagName("name").item(0).getTextContent();
                String phone = el.getElementsByTagName("phone").item(0).getTextContent();
                String email = el.getElementsByTagName("email").item(0).getTextContent();
                String area = el.getElementsByTagName("area").item(0).getTextContent();
                String city = el.getElementsByTagName("city").item(0).getTextContent();
            }
        }
    }