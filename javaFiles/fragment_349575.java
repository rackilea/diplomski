XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(
     new StringReader("<tag>foo&amp;bar</tag>"));
PrintWriter pw = new PrintWriter(System.out, true);
while (reader.hasNext())
{
    reader.next();
    pw.print(reader.getEventType());
    if (reader.hasText())
        pw.append(' ').append(reader.getText());
    pw.println();
}