SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
Schema myschema = factory.newSchema();
Validator validator = myschema.newValidator();
try {
  validator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
  validator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
  validator.validate(new StreamSource(new StringReader(xmlString)));
} catch ...