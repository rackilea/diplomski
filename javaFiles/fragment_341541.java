class MyFilter implements EventFilter {
  private final List<String> filtered = Arrays.asList("SOAP-ENV:Envelope",
      "SOAP-ENV:Body", "ns2:createCustomer");

  @Override
  public boolean accept(XMLEvent event) {
    if (event.isStartElement())
      for (String elementName : filtered)
        if (event.asStartElement().getName().getLocalPart().equals(
            elementName))
          return false;
    if (event.isEndElement())
      for (String elementName : filtered)
        if (event.asEndElement().getName().getLocalPart().equals(
            elementName))
          return false;
    return true;
  }
}