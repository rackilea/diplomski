public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

    String text = "<TextWithNodes>\n" +
            " <Node id=\"0\"/>A TEENAGER <Node\n" +
            "id=\"11\"/>yesterday<Node id=\"20\"/> accused his parents of cruelty\n" +
            "by feeding him a daily diet of chips which sent his weight\n" +
            "ballooning to 22st at the age of l2<Node id=\"146\"/>.<Node\n" +
            "id=\"147\"/>\n" +
            "</TextWithNodes>";
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    Document xmlDocument = builder.parse(new ByteArrayInputStream(text.getBytes("UTF-8")));
    XPath xPath = XPathFactory.newInstance().newXPath();
    String expression = "//TextWithNodes";
    System.out.println(xPath.compile(expression).evaluate(xmlDocument, XPathConstants.STRING));
}