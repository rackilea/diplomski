// checking for well-formed-ness using SAX.
SAXParserFactory factory = SAXParserFactory.newInstance();
factory.setValidating(true);
factory.setNamespaceAware(true);

SAXParser parser = factory.newSAXParser();
XMLReader reader = parser.getXMLReader();

reader.setErrorHandler(new SimpleErrorHandler());
reader.parse(new InputSource("src/addressbook.xml"));
System.out.println("Checked well-formed-ness using SAX ");


// validating using external schema Using SAX Parser
factory.setValidating(false); // set validation to false
SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
factory.setSchema(schemaFactory.newSchema(new Source[] { new StreamSource("src/addressbook.xsd") }));

parser = factory.newSAXParser(); // create a new parser
reader = parser.getXMLReader(); // and refresh your reader

reader.setErrorHandler(new SimpleErrorHandler());
reader.parse(new InputSource("src/addressbook.xml"));
System.out.println("Validation Checked when Parsing with SAX");


System.out.println("Parsing successful");