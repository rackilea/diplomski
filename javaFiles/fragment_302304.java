String xml;
try (StringWriter out = new StringWriter()) {
    JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(table1, out);
    xml = out.toString();
}
System.out.println(xml);