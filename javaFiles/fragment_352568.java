// the SAX way:
XMLReader myReader = XMLReaderFactory.createXMLReader();
myReader.setContentHandler(handler);
myReader.parse(new InputSource(new URL(url).openStream()));

// or if you prefer DOM:
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(new URL(url).openStream());