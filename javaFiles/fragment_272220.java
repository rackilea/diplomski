XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileOutputStream(...), StandardCharsets.UTF_8.name());
//"mannually" output the beginign of the xml document == its declaration and the root element
writer.writeStartDocument();
writer.writeStartElement("YOUR_ROOT_ELM");

Marshaller mar = ...
mar.setProperty(Marshaller.JAXB_FRAGMENT, true); //instructs jaxb to output only objects not the whole xml document

PartialUnmarshaler existing = ...; //allows reading one by one xml content from existin file, 

while (existing.hasNext()) {
    YourObject obj = existing.next();
    mar.marshal(obj, writer);
    writer.flush();
}

List<YourObject> toAppend = ...
for (YourObject toAppend) {
    mar.marshal(obj,writer);
    writer.flush();
}

//finishing the document, closing the root element
writer.writeEndElement();
writer.writeEndDocument();