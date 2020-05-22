String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><mySample xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" attribute1=\"value1\"/>";
XMLStreamReader reader = XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml));
while (reader.hasNext()) {
  int event = reader.next();
  if (XMLStreamConstants.START_ELEMENT == event) {
    if (reader.getNamespaceCount() > 0) {
      // This happens
      System.out.println("ELEMENT START: " + reader.getLocalName() + " , namespace count is: " + reader.getNamespaceCount());
      for (int nsIndex = 0; nsIndex < reader.getNamespaceCount(); nsIndex++) {
        String nsPrefix = reader.getNamespacePrefix(nsIndex);
        String nsId = reader.getNamespaceURI(nsIndex);
        System.out.println("\tNamepsace prefix: " + nsPrefix + " associated with URI " + nsId);
      }
    }
  } else if(XMLStreamConstants.NAMESPACE == event) {
    // This almost never happens
    System.out.println("NAMESPACE EVENT");
  }
}