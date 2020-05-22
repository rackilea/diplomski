try {

    // Create a document by parsing a XML file
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    Document document = builder.parse(new File("C:/temp/test.xml"));

    // Get a node using XPath
    XPath xPath = XPathFactory.newInstance().newXPath();
    String expression = "/project/version";
    Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);

    // Set the node content
    node.setTextContent("Whatever I want to write");

    // Write changes to a file
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(new DOMSource(document), new StreamResult(new File("C:/temp/test-updated.xml")));

} catch (Exception e) {
    // Handle exception
}