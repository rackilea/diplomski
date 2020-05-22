private static String getTagValue(NodeList list, String name) {
    for (int i = 0; i < list.getLength(); i++) {
        Element e = (Element) list.item(i);
        if (e.getAttribute("name").equals(name)) {
            return e.getTextContent();
        }
    }
    return null;
}

public static void main(String[] args) throws Exception {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            .parse(new File("1.xml"));
    NodeList fields = doc.getElementsByTagName("field");
    String country = getTagValue(fields, "Country or Area");
    String year = getTagValue(fields, "Year");
}