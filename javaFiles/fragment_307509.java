SAXParserFactory parserFactory = SAXParserFactory.newInstance();
SAXParser saxParser = parserFactory.newSAXParser();
XMLReader xmlReader = saxParser.getXMLReader();

EntityResolver entityReolver = new EntityResolver() {
    public InputSource resolveEntity(String publicId, String systemId) {
    try {
        System.out.println("Entity resolving systemID... " + publicId);
        if (systemId.indexOf((".dtd")) != -1) {
            System.out.println("Entity Resolved...");
            return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
        }
    } catch (Exception e) {
    }
    return null;
    }
};
xmlReader.setEntityResolver(entityReolver);

SAXSource saxSource = new SAXSource(xmlReader, SAXSource.sourceToInputSource(new   StreamSource(xmlFile)));
transformer.transform(saxSource, result);