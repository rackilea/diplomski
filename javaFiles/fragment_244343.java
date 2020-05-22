public class PersonlistProcessor {
    public static void main(String[] args) throws Exception {
        new PersonlistProcessor().processPersonlist(PersonlistProcessor.class
                .getResourceAsStream("personlist.xml"));
    }

    // TODO: Instead of throws Exception, all exceptions should be wrapped
    // inside runtime exception
    public void processPersonlist(InputStream inputStream) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        XMLStreamReader xss = XMLInputFactory.newFactory().createXMLStreamReader(inputStream);
        // Create unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        // Go to next tag
        xss.nextTag();
        // Require Personlist
        xss.require(XMLStreamReader.START_ELEMENT, "http://example.org", "Personlist");
        // Go to next tag
        while (xss.nextTag() == XMLStreamReader.START_ELEMENT) {
            // Require Person
            xss.require(XMLStreamReader.START_ELEMENT, "http://example.org", "Person");
            // Unmarshall person
            Person person = (Person)unmarshaller.unmarshal(xss);
            // Process person
            processPerson(person);
        }
        // Require Personlist
        xss.require(XMLStreamReader.END_ELEMENT, "http://example.org", "Personlist");
    }

    private void processPerson(Person person) {
        System.out.println(person.getName());
        System.out.println(person.getAddress().getCountryName());
    }
}