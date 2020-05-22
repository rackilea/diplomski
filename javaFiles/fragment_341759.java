static Transformer transformer;

static {
    try {
        transformer = TransformerFactory.newInstance().newTransformer();
    } catch (TransformerConfigurationException e) {
    } catch (TransformerFactoryConfigurationError e) {
    }
}

static byte[] compress(String xml) throws IOException, EXIException,
        SAXException {
    ByteArrayOutputStream exiOS = new ByteArrayOutputStream();
    EXIResult exiResult = new EXIResult();
    exiResult.setOutputStream(exiOS);

    XMLReader xmlReader = XMLReaderFactory.createXMLReader();
    xmlReader.setContentHandler(exiResult.getHandler());
    xmlReader.parse(new InputSource(new StringReader(xml)));

    byte[] compressed = exiOS.toByteArray();
    exiOS.close();

    return compressed;
}

static String extract(byte[] compressed) throws TransformerException,
        IOException, EXIException {
    // SAXSource exiSource = new SAXSource(new InputSource(new
    // ByteArrayInputStream(compressed))); // use EXISource instead!
    SAXSource exiSource = new EXISource();
    exiSource.setInputSource(new InputSource(new ByteArrayInputStream(
            compressed)));

    ByteArrayOutputStream exiOS = new ByteArrayOutputStream();
    transformer.transform(exiSource, new StreamResult(exiOS));
    String extracted = exiOS.toString();
    exiOS.close();
    return extracted;
}

public static void main(String[] args) throws IOException, EXIException,
        SAXException, TransformerException {
    String xml = "<Root><Child id=\"1\">Text</Child><EmptyTag/></Root>";
    byte[] compressed = ExiCompressionUtils.compress(xml);
    System.out.println(ExiCompressionUtils.extract(compressed));
}