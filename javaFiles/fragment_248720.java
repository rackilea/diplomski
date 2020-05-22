public static void main(String[] args) throws Exception {
    String xmlString = "<MainTag><element><tag1>Key1</tag1><tag2>Not intrested</tag2><tag3>Value1</tag3></element><element><tag1>Key2</tag1><tag2>Not intrested</tag2></element><element><tag1>Key3</tag1><tag2>Not intrested</tag2><tag3>Value3</tag3></element></MainTag>";
    Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(xmlString.getBytes("utf-8"))));

    Node rootNode = xmlDocument.getFirstChild();
    if (rootNode.hasChildNodes()) {
        // Get each element child node
        NodeList elementsList = rootNode.getChildNodes();
        for (int i = 0; i < elementsList.getLength(); i++) {
            if (elementsList.item(i).hasChildNodes()) {
                // Get each tag child node to element node
                NodeList tagsList = elementsList.item(i).getChildNodes();
                for (int i2 = 0; i2 < tagsList.getLength(); i2++) {
                    Node tagNode = tagsList.item(i2);
                    if (tagNode.getNodeName().matches("tag1|tag3")) {
                        System.out.println(tagNode.getNodeName() + " " + tagNode.getTextContent());
                    }
                }
            }
        }
    }
}