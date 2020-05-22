final List<SAXParseException> exceptions = new LinkedList<SAXParseException>();
  validator.setErrorHandler(new ErrorHandler()
  {
    @Override
    public void warning(SAXParseException exception) throws SAXException
    {
      exceptions.add(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException
    {
      exceptions.add(exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException
    {
      exceptions.add(exception);
    }
  });