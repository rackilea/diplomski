SAXParserFactory factory = SAXParserFactory.newInstance();
factory.setValidating(true);
factory.setNamespaceAware(true);

SAXParser parser = factory.newSAXParser();

XMLReader reader = parser.getXMLReader();
reader.setErrorHandler(new SimpleErrorHandler());
reader.parse(new InputSource(new FileReader ("document.xml")));