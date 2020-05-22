DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = dbf.newDocumentBuilder();
builder.setErrorHandler(new ErrorHandler() {

  @Override
  public void warning(SAXParseException exception) throws SAXException {
    System.err.println("warning: caught exception");
    exception.printStackTrace(System.err);
  }

  @Override
  public void fatalError(SAXParseException exception) throws SAXException {
    System.err.println("fatalError: caught exception");
    exception.printStackTrace(System.err);
  }

  @Override
  public void error(SAXParseException exception) throws SAXException {
    System.err.println("error: caught exception");
    exception.printStackTrace(System.err);
  }
});