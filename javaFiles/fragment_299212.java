class CustomResolver implements javax.xml.stream.XMLResolver {

  public Object resolveEntity(String publicID,
                              String systemID,
                              String baseURI,
                              String namespace)
                  throws XMLStreamException 
  {
    if ("The public ID you expect".equals(publicID)) {
      return getClass().getResourceAsStream("doc.dtd");
    } else {
      return null;
    }
  }