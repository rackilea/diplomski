DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
SchemaFactory scf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
URL schemaUrl = getClass().getResource(SCHEMAFILE);

dbf.setNamespaceAware(true);
dbf.setSchema(schema);

DocumentBuilder builder = dbf.newDocumentBuilder();
builder.setErrorHandler(errHandler);
Document doc = builder.parse(input);