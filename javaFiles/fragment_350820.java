SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
String path = locationXSD.substring(0, locationXSD.lastIndexOf('/')+1);
Source schemaFile = new StreamSource(TemplateHandler.class.getClassLoader().getResourceAsStream(locationXSD));
schema = factory.newSchema(schemaFile);//thread safe object which can be reused

DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
builderFactory.setNamespaceAware(true);
builderFactory.setSchema(schema);
DocumentBuilder builder = builderFactory.newDocumentBuilder();
document = builder.parse(new InputSource(new StringReader(xml)));

Validator validator = schema.newValidator();
validator.validate(new DOMSource(document));