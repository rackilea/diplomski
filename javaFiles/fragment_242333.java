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

public static void main(String arg[]) throws Exception
{

    String res="<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><SubtractResponse xmlns=\"http://tempuri.org/\"><SubtractResult>150</SubtractResult></SubtractResponse></soap:Body></soap:Envelope>";
    List<String> output = XmlResponseToObject.getFullNameFromXml(res, "SubtractResult");
    String[] strarray = new String[output.size()];
    output.toArray(strarray);
    String x = output.get(0);
    System.out.println(x);
}