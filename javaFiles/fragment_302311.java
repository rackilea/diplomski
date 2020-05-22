String raw = "<CONTENT><DETAIL><USER>user1</USER><MAIL>abc@test.com</MAIL></DETAIL><DETAIL><USER>user2</USER><MAIL>def@test.com</MAIL></DETAIL></CONTENT>";
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder;

try {
    dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new ByteArrayInputStream(raw.getBytes()));
    NodeList nodes = doc.getElementsByTagName("DETAIL");
    for (int idx = 0; idx < nodes.getLength(); idx++) {
        Node node = nodes.item(idx);
        System.out.println("User: "+((Element)node).getElementsByTagName("USER").item(0).getTextContent());
        System.out.println("Mail: "+((Element)node).getElementsByTagName("MAIL").item(0).getTextContent());
    }
} catch (Exception ex) {
    // do stuff
}