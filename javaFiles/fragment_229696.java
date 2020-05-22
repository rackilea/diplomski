// Create a JAXB context from the POJO classes (you should have defined the XSD before)
    final JAXBContext context = JAXBContext.newInstance(Drugs.class);

    Unmarshaller unmarshaller;
    unmarshaller = context.createUnmarshaller();
    unmarshaller.setSchema(null);
    // create a new XML parser
    SAXParserFactory factory = SAXParserFactory.newInstance();
    factory.setNamespaceAware(true);
    XMLReader reader = factory.newSAXParser().getXMLReader();

    // JAXB marshaller
    reader.setContentHandler(unmarshaller.getUnmarshallerHandler());

    // This is the buffer from you are reading (i.e. this can be the XML file)
    reader.parse(new InputSource(inputBuffer));

    Drugs result = (Drugs) marshaller.getUnmarshallerHandler().getResult();
    // Now you can build a hashmap with the drugs you have retrieved