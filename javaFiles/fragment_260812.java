StringWriter sw = new StringWriter();
XMLStreamWriter xsw = XMLOutputFactory.newInstance().createXMLStreamWriter(sw);
xsw = new DelegatingXMLStreamWriter(xsw) {
    @Override
    public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
        String s = localName;
        super.writeStartElement(prefix, Character.toUpperCase(s.charAt(0)) + s.substring(1), namespaceURI);
    }
};

Marshaller m = jc.createMarshaller();
JAXBElement<Person> jaxbElement = new JAXBElement<Person>(new QName(Person.class.getSimpleName()), Person.class, person);
m.marshal(jaxbElement, xsw);