String ctxtTemplate = "<data xmlns=\"http://base\" xmlns:foo=\"http://foo\" />";
NamespaceContext nsContext = null;

XMLInputFactory factory = XMLInputFactory.newInstance();
XMLEventReader evtReader = factory
    .createXMLEventReader(new StringReader(ctxtTemplate));
while (evtReader.hasNext()) {
  XMLEvent event = evtReader.nextEvent();
  if (event.isStartElement()) {
    nsContext = ((StartElement) event)
        .getNamespaceContext();
    break;
  }
}

System.out.println(nsContext.getNamespaceURI(""));
System.out.println(nsContext.getNamespaceURI("foo"));
System.out.println(nsContext
    .getNamespaceURI(XMLConstants.XMLNS_ATTRIBUTE));
System.out.println(nsContext
    .getNamespaceURI(XMLConstants.XML_NS_PREFIX));