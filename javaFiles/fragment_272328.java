SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser sp = spf.newSAXParser();
    XMLReader xr = sp.getXMLReader();

    JAXBContext jc = JAXBContext.newInstance("blog.log4j");
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
    xr.setContentHandler(unmarshallerHandler);

    FileInputStream xmlStream = new FileInputStream("src/blog/log4j/sample1.xml");
    InputSource xmlSource = new InputSource(xmlStream);
    xr.parse(xmlSource);

    Log4JConfiguration config = (Log4JConfiguration) unmarshallerHandler.getResult();

    Marshaller marshaller = jc.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(config, System.out);