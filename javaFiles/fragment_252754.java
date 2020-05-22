public void modifyXML() {
    try {
        JAXBContext context = JAXBContext.newInstance(Assets.class, Image.class);
        Unmarshaller um = context.createUnmarshaller();
        // This xml should be formatted in a way that JAXB can work with
        String rawXML = getRawXML("/path/to/my.xml");
        // Hand the modified xml to the unmarshaller
        Assets umAssets = (Assets) um.unmarshal(new StreamSource(new StringReader(rawXML)));
        // Do stuff with umAssets
        ...
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private String getRawXML(String path) throws IOException {
    String xml = readFile(path, StandardCharsets.UTF_8);
    // This should make it so JAXB can handle the xml properly
    xml = xml.replaceAll("<main-asset-name>", "<image>");
    xml = xml.replaceAll("</main-asset-name>", "</image>");
    xml = xml.replaceAll("<product-image.*>", "<image>");
    return xml.replaceAll("</product-image.*>", "</image>");
}

private String readFile(String path, Charset encoding) throws IOException {
    // A simple file reader
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
}