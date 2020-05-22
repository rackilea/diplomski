public String getMimetype(BaseDocument document) {
    ContentHandler contenthandler = new BodyContentHandler();
    Metadata metadata = new Metadata();
    metadata.set(Metadata.RESOURCE_NAME_KEY, document.getName());
    Parser parser = new AutoDetectParser();
    try {
        parser.parse(new ByteArrayInputStream(document.getFile()), contenthandler, metadata, null);
    } catch (IOException | SAXException | TikaException e) {
        //throw
    }

    return metadata.get(Metadata.CONTENT_TYPE);
}