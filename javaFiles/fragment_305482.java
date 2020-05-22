JAXBContext jc = JAXBContext.newInstance("com.acme.foo:com.acme.bar" );
Umarshaller u = jc.createUnmarshaller();  
u.setValidating(true);
SchemaFactory sf = SchemaFactory.newInstance(
      javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
Schema schema = sf.newSchema(new File("mySchema.xsd"));
u.setSchema(schema);
MyObject myObj = (MyObject)u.unmarshal( new File( "myFile.xml" ) );