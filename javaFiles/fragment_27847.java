private static void useStaxon(File tempJson) throws Exception {
    XMLInputFactory factory = new JsonXMLInputFactory();
    XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(tempJson));
    while (true) {
        if (reader.getEventType() == XMLStreamConstants.END_DOCUMENT)
            break;
        if (reader.isCharacters()) {
            long len = reader.getTextLength();
            String text;
            if (len > 20) {
                char[] buffer = new char[20];
                reader.getTextCharacters(0, buffer, 0, buffer.length);
                text = new String(buffer) + "...";
            } else {
                text = reader.getText();
            }
            System.out.println("String: " + text + " (length=" + len + ")");
        }
        reader.next();
    }
    reader.close();
}