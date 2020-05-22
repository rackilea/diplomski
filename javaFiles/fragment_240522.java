// Create the marshaller for the class Book
JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

// Create the main XMLStreamWriter
XMLOutputFactory output = XMLOutputFactory.newInstance();
XMLStreamWriter writer = output.createXMLStreamWriter(System.out);

// Apply the custom XMLStreamWriter that will remove the first character
// of each text content
jaxbMarshaller.marshal(book, new RemoveFirstCharacter(writer));