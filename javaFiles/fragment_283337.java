class NoRoot extends XMLFilterImpl {

  private int depth;

  @Override public void startDocument() throws SAXException
  {
    depth = 0;
  }

  @Override public void startElement(String uri, String localName,
                                     String qName, Attributes atts)
    throws SAXException
  {
    if (depth != 0) super.startElement(uri, localName, qName, atts);
    ++depth;
  }

  @Override public void endElement(String uri, String localName,
                                   String qName)
    throws SAXException
  {
    --depth;
    if (depth != 0) super.endElement(uri, localName, qName);
  }

}