SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
    Schema schema = sf.newSchema(new File("your.xsd"));

    marshaller.setSchema(schema);
    marshaller.setEventHandler(new ValidationEventHandler() {
      public boolean handleEvent(ValidationEvent event) {
        System.out.println(event);
        return false; //to stop the marshal if anything happened
      }
    });