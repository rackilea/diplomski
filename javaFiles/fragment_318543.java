finalHandler = new StreamResult(new OutputStreamWriter(System.out));
  // customHandler extends DefaultHandler
  CustomTransformerHandler customHandler = new CustomTransformerHandler(
         finalHandler);
  customHandler.startDocumentExplicitly();
  InputStream is = null;
  while ((is = customHandler.createNextInputStream()) != null) {
    // multiple inputStream parsing
    XMLReader myReader = XMLReaderFactory.createXMLReader();
    myReader.setContentHandler(customHandler);
    myReader.parse(new InputSource(is));
  }
  customHandler.endDocumentExplicitly();