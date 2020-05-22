public List<Person> testeUnmarshal() {
  List<Person> people = new ArrayList<Person>();
  Person p = null;
  try {
    JAXBContext context = JAXBContext.newInstance(Person.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    File f = new File(FILE_PATH);
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(f));
    while (eventReader.hasNext()) {
      XMLEvent event = eventReader.peek();
      if (event.isStartElement()) {
        StartElement start = event.asStartElement();
    if (start.getName().getLocalPart() == "person")) {
          JAXBElement<Person> jax_b = unmarshaller.unmarshal(eventReader, Person.class);
      p = jax_b.getValue();
    }
      }
      eventReader.next();
    }
  } catch (Exception e) {
  }
  return persons;
}