public static String changeProductVersion(String reqXML, String xpathExpression) {

    Document document = null;
    String updatedXML = null;

    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(reqXML));
        document = builder.parse(is);

        XPath xPath = XPathFactory.newInstance().newXPath();
        Element element = (Element) xPath
                .compile(xpathExpression)
                .evaluate(document, XPathConstants.NODE);

        if(element != null) {
            NodeList childNodes = element.getChildNodes();

            // Get the first node which should be the text value.
            // Add some validation to make sure Node == Node.TEXT_NODE.
            Node node = (Node) childNodes.item(0);
            node.setTextContent("17.1.0");
        }

        System.out.println("Updated element value: " + element.getTextContent());

        // Serialise the updated DOM
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new StringWriter());
        transformer.transform(source, result);

        updatedXML = result.getWriter().toString();

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    System.out.println(updatedXML);
    return updatedXML;
}