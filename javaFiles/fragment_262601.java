private String marshallObject(MyObject myObject) throws JAXBException{
    JAXBContext jaxbContext = JAXBContext.newInstance(MyObject.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.setAdapter(new CalendarDateTimeAdapter());
    StringWriter sw = new StringWriter();
    jaxbMarshaller.marshal(myObject, sw);
    String output = sw.toString();
    return output;
}