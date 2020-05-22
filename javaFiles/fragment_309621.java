SAXParserFactory factory1 = SAXParserFactory.newInstance();
factory1.setValidating(false);
factory1.setNamespaceAware(true);

SAXParser parser = factory1.newSAXParser();
XMLReader xmlreader = parser.getXMLReader();
xmlreader.setEntityResolver(entityResolver);

Source source = new SAXSource(xmlreader, new InputSource(stream));