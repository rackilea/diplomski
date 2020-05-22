MDASJ xml = ....;
JAXBContext context = JAXBContext.newInstance(MDASJ.class);
Marshaller m = context.createMarshaller();
m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
m.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                     "http://www.theronyx.com/mdasj/xmldata mdasj-data.xsd");
m.setProperty("com.sun.xml.bind.namespacePrefixMapper",new MyPrefixMapper());
m.marshal(xml, System.out);