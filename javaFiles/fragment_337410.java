public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException {
        FileInputStream path = new FileInputStream("text.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(path);
        System.out.println();
        traverse(document.getDocumentElement());

    }

    public static void traverse(Node node) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node currentNode = list.item(i);
            traverse(currentNode);

        }

        if (node.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE) {
            System.out.println("This -> " + node.getTextContent());
        }

    }