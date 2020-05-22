final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
final XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
final XMLEventReader xmlReader = xmlInputFactory.createXMLEventReader(yourInputStream);
final XMLEventWriter xmlWriter = xmlOutputFactory .createXMLEventWriter(yourOutputStream); //The place where the resulting partial XML will go

while (xmlReader.hasNext()) {
    XMLEvent event = xmlReader.nextEvent();

    if (event ... some validation) {
        xmlWriter.add(event); //Forward it to xmlWriter
    }

    if (we have read enough elements) {
        break;
    }
}
xmlReader.close();
xmlWriter.flush();
xmlWriter.close();