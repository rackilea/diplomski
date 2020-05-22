public static void splitXML() throws Exception {

    int batchSize = 2;
    List<String> splittedXMLs = new ArrayList<String>();
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<RootElement>\n" +
            "   <ApplicationArea>\n" +
            "      <Test />\n" +
            "   </ApplicationArea>\n" +
            "   <DataArea>\n" +
            "      <Employ>\n" +
            "         <eno />\n" +
            "         <employName />\n" +
            "      </Employ>\n" +
            "      <Employ>\n" +
            "         <eno />\n" +
            "         <employName />\n" +
            "      </Employ>\n" +
            "      <Employ>\n" +
            "         <eno />\n" +
            "         <employName />\n" +
            "      </Employ>\n" +
            "      <Employ>\n" +
            "         <eno />\n" +
            "         <employName />\n" +
            "      </Employ>\n" +
            "      <Employ>\n" +
            "         <eno />\n" +
            "         <employName />\n" +
            "      </Employ>\n" +
            "      <Employ>\n" +
            "         <eno />\n" +
            "         <employName />\n" +
            "      </Employ>\n" +
            "   </DataArea>\n" +
            "</RootElement>";
    System.out.println(xml);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));


    // This is going to be our base document for new document.
    Document newDoc = dBuilder.newDocument();
    Node importedNode = newDoc.importNode(doc.getDocumentElement(), true);
    newDoc.appendChild(importedNode);

    Element dataAreaElement = (Element) newDoc.getElementsByTagName("DataArea").item(0);
    removeChildren(dataAreaElement);

    Document splittedDoc = (Document) newDoc.cloneNode(true);

    List<Node> employList = new ArrayList<Node>();
    NodeList dataArea = doc.getElementsByTagName("Employ");
    for (int i = 0; i < dataArea.getLength(); i++) {
        employList.add(dataArea.item(i));
        if (i % batchSize == 0 || i == dataArea.getLength() - 1) {
            Node dataAreaNode = splittedDoc.getDocumentElement().getElementsByTagName("DataArea").item(0);
            for (Node node1 : employList) {

                dataAreaNode.appendChild(splittedDoc.importNode(node1, true));
            }
            employList.clear();
            splittedXMLs.add(convertDocumentToString(splittedDoc));
            splittedDoc = (Document) newDoc.cloneNode(true);
        }
    }

    // Printing all splitted XMLs
    for (String splittedXML : splittedXMLs) {
        System.out.println("##### " + splittedXML);
    }

}

public static void removeChildren(Node node) {
    while (node.hasChildNodes())
        node.removeChild(node.getFirstChild());
}

private static String convertDocumentToString(Document doc) {
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer;
    try {
        transformer = tf.newTransformer();
        // below code to remove XML declaration
        // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String output = writer.getBuffer().toString();
        return output;
    } catch (TransformerException e) {
        e.printStackTrace();
    }

    return null;
}