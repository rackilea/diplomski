public static Document loadXMLString(String response) throws Exception
{
    DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    InputSource is = new InputSource(new StringReader(response));

    return db.parse(is);
}

public static List<String> getFullNameFromXml(String response, String tagName) throws Exception {
    Document xmlDoc = loadXMLString(response);
    NodeList nodeList = xmlDoc.getElementsByTagName(tagName);
    List<String> ids = new ArrayList<String>(nodeList.getLength());
    for(int i=0;i<nodeList.getLength(); i++) {
        Node x = nodeList.item(i);
        ids.add(x.getFirstChild().getNodeValue());             
        System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
    }
    return ids;
}