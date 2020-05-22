Foo streamCapture = new Foo();
SplittingInputStreamReader streamReader = new SplittingInputStreamReader(
   new InputStreamReader(socket.getInputStream(), "ISO8859_1"), streamCapture);
InputSource is = new InputSource(streamReader);
XMLReader reader = XMLReaderFactory.createXMLReader();
reader.setContentHandler(new ResponseParseHandler(etc, id));
reader.parse(is);
// After parse, if there was an error, check what is in Foo streamCapture