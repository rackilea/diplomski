XMLOutputFactory factory = XMLOutputFactory
    .newInstance();
XMLStreamWriter writer = factory.createXMLStreamWriter(
    stream, "UTF-8");
try {
  writer.writeStartDocument("UTF-8", "1.0");
  writer.writeStartElement("pie");
  for (Entry<String, String> entry : map.entrySet()) {
    writer.writeStartElement("slice");
    writer.writeAttribute("title", entry.getKey());
    writer.writeCharacters(entry.getValue());
    writer.writeEndElement();
  }
  writer.writeEndElement();
  writer.writeEndDocument();
} finally {
  writer.close();
}