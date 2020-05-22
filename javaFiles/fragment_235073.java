DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
domFactory.setValidating(true);
DocumentBuilder builder = domFactory.newDocumentBuilder();
builder.setErrorHandler(new ErrorHandler() {
    @Override
    public void error(SAXParseException exception) throws SAXException {
        // do something more useful in each of these handlers
        exception.printStackTrace();
    }
    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        exception.printStackTrace();
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        exception.printStackTrace();
    }
});
Document doc = builder.parse("employee.xml");