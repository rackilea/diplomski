FileOutputStream fos = new FileOutputStream("foo.xml");
XMLStreamWriter writer = XMLOutputFactory.newFactory().createXMLStreamWriter(fos);

writer.writeStartDocument();
writer.writeStartElement("Import");
writer.writeStartElement("WorkSets");

JAXBContext context = JAXBContext.newInstance(WorkSet.class);
Marshaller m = context.createMarshaller();
m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); 
for (WorkSet instance : instances)
{
    JAXBElement<WorkSet> element = new JAXBElement<WorkSet>(QName.valueOf("WorkSet"), WorkSet.class, instance);
    m.marshal(element, writer);
}

writer.writeEndDocument(); // this will close any open tags
writer.close();