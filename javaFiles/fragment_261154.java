DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document document = builder.parse(new File(inputfile));
document.getDocumentElement().normalize();

NodeList AuthTokens = document.getElementsByTagName("AuthToken");
// NodeList AuthTokens = document.getElementsByTagName("ServerPath");
int num = AuthTokens.getLength();
for (int i = 0; i < num; i++) {
    Node node = AuthTokens.item(i);
    String token = node.getTextContent();
    System.out.println(token);
}