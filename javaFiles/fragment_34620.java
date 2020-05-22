class GraphDataStreamReader extends StreamReaderDelegate {
  public GraphDataStreamReader(XMLStreamReader reader) {
    super(reader);
  }

  public void nextStartElement() throws XMLStreamException {
    do {
      super.next();
    } while (!super.isStartElement());
  }
}

XMLInputFactory factory = XMLInputFactory.newInstance();
GraphDataStreamReader streamReader = new GraphDataStreamReader(
                                 factory.createXMLStreamReader(fileInputStream));
streamReader.next();
streamReader.nextStartElement();