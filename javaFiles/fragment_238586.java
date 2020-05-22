try {
  schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
  schema = schemaFactory.newSchema(new Source[] {
    new StreamSource(xsd1), new StreamSource(xsd2)
  });
} catch (SAXException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
}