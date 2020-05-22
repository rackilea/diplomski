public static void main(String[] args)
            throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {

        String myDocumentStr = "<shop><shoes>brand1</shoes><tshirt>brand2</tshirt><socks>brand3</socks></shop>";
        Node myDocument = getNode(myDocumentStr);

        XPathExpression path = XPathFactory.newInstance().newXPath().compile("/shop/*");

        NodeList nodeList = (NodeList) path.evaluate(myDocument, XPathConstants.NODESET);

        System.out.println(nodeList.getLength());

        myDocumentStr = "<shop></shop>";
        myDocument = getNode(myDocumentStr);
        nodeList = (NodeList) path.evaluate(myDocument, XPathConstants.NODESET);

        System.out.println(nodeList.getLength());
    }

    private static Node getNode(String myDocumentStr) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        Node myDocument = builder.parse(new ByteArrayInputStream(myDocumentStr.getBytes()));
        return myDocument;
    }