InputStream xmlStream = ...

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    factory.setValidating(true);
    factory.setXIncludeAware(true);
    factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
    factory.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
    factory.setFeature("http://apache.org/xml/features/honour-all-schemaLocations", true);
    factory.setFeature("http://apache.org/xml/features/validate-annotations", true);
    factory.setFeature("http://apache.org/xml/features/generate-synthetic-annotations", true);

    DocumentBuilder builder = factory.newDocumentBuilder();
    builder.setErrorHandler(new ErrorHandler() {
        public void warning(SAXParseException exception) throws SAXException {
            LOG.log(Level.WARNING, "parse warn: " + exception, exception);
        }
        public void error(SAXParseException exception) throws SAXException {
            LOG.log(Level.SEVERE, "parse error: " + exception, exception);
        }
        public void fatalError(SAXParseException exception) throws SAXException {
            LOG.log(Level.SEVERE, "parse fatal: " + exception, exception);
        }
    });

    Document doc = builder.parse(xmlStream);