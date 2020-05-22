public static void main(String[] args) throws SAXException, IOException,
        ParserConfigurationException, TransformerException {

    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
        .newInstance();
    DocumentBuilder doc = docBuilderFactory.newDocumentBuilder();
    Document document = doc.parse(new File("doc.xml"));
    childRecusrsion(document.getDocumentElement());
}