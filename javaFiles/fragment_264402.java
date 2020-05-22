DocumentBuilder documentBuilder =
    DocumentBuilderFactory.newInstance().newDocumentBuilder();
Reader in = new StringReader(message);
Document document = documentBuilder.parse(new InputSource(in));
in.close();
NodeList nodes = document.getElementsByTagName("BalDtoList");
for(int i = 0; i < nodes.getLength(); i++) {
    Element elem = (Element) nodes.item(i);
    System.out.println(i + ":");
    for (String name : new String[] {
        "BalID", "AcctResID", "BalType", "Balance", "EffDate"
    }) {
        String value = elem.getElementsByTagName(name).item(0).getTextContent();
        System.out.println(name + " = " + value);
    }
}