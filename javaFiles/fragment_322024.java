SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
Schema schema = schemaFactory.newSchema(locationOfMySchema); 

Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.setSchema(schema);
marshaller.marshal(objectToMarshal, new DefaultHandler());