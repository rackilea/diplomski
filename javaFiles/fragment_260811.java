String xml = "<Person><FirstName>John</FirstName><LastName>Doe</LastName></Person>";

XMLStreamReader xsr = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(xml));
xsr = new StreamReaderDelegate(xsr) {
    @Override
    public String getLocalName() {
        String s = super.getLocalName(); 
        return Character.toLowerCase(s.charAt(0)) + s.substring(1); 
    }
};

JAXBContext jc = JAXBContext.newInstance(Person.class);
Unmarshaller u = jc.createUnmarshaller();
Person person = u.unmarshal(xsr, Person.class).getValue();