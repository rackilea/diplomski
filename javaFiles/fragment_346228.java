public static void main(String[] args) throws IOException, ParserConfigurationException {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = factory.newDocumentBuilder();

    Document doc = null;
    try {
        doc = dBuilder.parse("test.xml");
    } catch (SAXException e) {
       // do some logging of your own or something
    }

    System.out.println("done");
}