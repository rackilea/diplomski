public void unmarshal() throws FileNotFoundException{
    Unmarshaller unmarshaller;
    try {
        JAXBContext ctx = JAXBContext.newInstance(ObjectFactory.class);
        unmarshaller = ctx.createUnmarshaller();

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        StreamSource streamSource = new StreamSource("path/to/some.xml");
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(streamSource);
        JAXBElement<SomeClass> sc = unmarshaller.unmarshal(xmlStreamReader, SomeClass.class);//error here
        System.out.println("title is: "+sc.getValue().getTitle());
    } catch (JAXBException e) {e.printStackTrace();}
}