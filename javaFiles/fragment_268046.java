try {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("code.xml"));
    XPath xPath = XPathFactory.newInstance().newXPath();
    XPathExpression exp = xPath.compile("//name");
    NodeList nl = (NodeList) exp.evaluate(doc, XPathConstants.NODESET);
    for (int index = 0; index < nl.getLength(); index++) {
        Node node = nl.item(index);
        Node parent = node.getParentNode();
        System.out.println("Parent: " + parent.getNodeName());
        System.out.println("    Name: " + node.getTextContent());

    }
} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
    ex.printStackTrace();
}