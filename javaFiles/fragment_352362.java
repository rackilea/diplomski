createOutputFile("output.xml", transformToString(document));

private static String transformToString(Document document) {
    try {
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        StringWriter buffer = new StringWriter();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(buffer));
        return buffer.toString();
    } catch (TransformerException e) {
        throw new RuntimeException(e);
    }
}


private static void createOutputFile(String filePath, String content) {
    FileWriter writer = null;
    try {
        try {
            writer = new FileWriter(filePath);
            writer.write(content);
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close(); 
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}