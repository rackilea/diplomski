DOMResult result = new DOMResult();
XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
XMLEventReader reader = xmlInputFactory
    .createXMLEventReader(new StreamSource(new File("soap.xml")));
reader = xmlInputFactory.createFilteredReader(reader, new MyFilter());
TransformerFactory transFactory = TransformerFactory.newInstance();
Transformer transformer = transFactory.newTransformer();
transformer.transform(new StAXSource(reader), result);
Document document = (Document) result.getNode();