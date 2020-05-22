try {
    URL schemaSource = Thread.currentThread().getContextClassLoader().getResource("JNLP-6.0.xsd");
    System.out.println( "schemaSource: " + schemaSource );

    DocumentBuilderFactory factory =
        DocumentBuilderFactory.newInstance();
    factory.setFeature("http://xml.org/sax/features/validation", true);
    factory.setFeature("http://apache.org/xml/features/validation/schema", true) ;
    factory.setFeature("http://xml.org/sax/features/namespaces", true) ;
    factory.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
    factory.setAttribute(
        "http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation",
        schemaSource.toString());
    factory.setNamespaceAware(true);
    factory.setValidating(true);

    InputStream schemaStream = schemaSource.openStream();
    try {
        StreamSource ss = new StreamSource( schemaStream );
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);

        Schema schema = schemaFactory.newSchema(ss);
        factory.setSchema( schema );
    }
    finally {
        schemaStream.close();
    }

    DocumentBuilder documentBuilder = factory.newDocumentBuilder();
    documentBuilder.setErrorHandler( errorHandler );

    InputStream is = page.openStream();
    try {
        document = documentBuilder.parse( is );
    }
    finally {
        is.close();
    }

    List<LaunchError> parseErrors = errorHandler.getParseErrors();
    xmlValid = parseErrors.isEmpty();
    errors.addAll(parseErrors);
} catch(Exception e) {
    System.err.println( "Error: " + e.getMessage() );
    // TODO Show to user
}