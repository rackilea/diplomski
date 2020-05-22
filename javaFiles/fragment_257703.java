db.setErrorHandler(new ErrorHandler() {
    @Override
    public void warning(SAXParseException e) throws SAXException {
        ;
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        throw e;
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        throw e;
    }
});