public class SaveXmlWithCustomXmlHeader {

    public static void main(String[] args) throws Exception {
        String xmlString = "<a><b></b><c></c></a>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveXMLDocument(document, "hello.xml");
    }

    public static void saveXMLDocument(Document xodrDoc, String absoluteFileName) throws Exception {
        // add custom xml tag
        ProcessingInstruction newPI = xodrDoc.createProcessingInstruction("xml", "version=\"1.0\" standard=\"yes\"");
        xodrDoc.insertBefore(newPI, xodrDoc.getDocumentElement());

        //write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(xodrDoc);
        StreamResult result = new StreamResult(new File(absoluteFileName));

        transformer.transform(source, result);
    }
}