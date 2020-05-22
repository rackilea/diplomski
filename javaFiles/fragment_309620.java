DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setValidating(false);
factory.setNamespaceAware(true);

DocumentBuilder builder = factory.newDocumentBuilder();
DocumentBuilder builder = ...
builder.setEntityResolver(entityResolver);

Source source = new DOMSource(builder.parse(inputStream));