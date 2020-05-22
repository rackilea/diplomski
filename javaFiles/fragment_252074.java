JAXBContext con = JAXBContext.newInstance(Xmeml.class);
SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
Schema schema = sf.newSchema(new File("D:\\Temp\\schema\\schema1.xsd"));
Unmarshaller umar = con.createUnmarshaller();
umar.setSchema(schema);
Xmeml mem = (Xmeml)umar.unmarshal(new File("D:\\Temp\\testcase\\Surround Test.xml"));