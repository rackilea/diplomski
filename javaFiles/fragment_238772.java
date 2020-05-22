DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();

try {
    builder.parse(url);
} catch (IOException e) {
    e.printStackTrace();
} catch (SAXParseException e) {
    e.printStackTrace();
} catch (IllegalArgumentException e) {
    e.printStackTrace();
}