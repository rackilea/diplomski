//Source source = your SAXSource
DOMResult result = new DOMResult();
TransformerFactory.newInstance()
    .newTransformer()
    .transform(source, result);
Document doc = (Document) result.getNode();