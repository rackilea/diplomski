public Student unMarshall(String input){
    JAXBContext context;
    try {
        context = JAXBContext.newInstance(Student.class);
        Unmarshaller m = context.createUnmarshaller();
        StreamSource source = new StreamSource(new StringReader(input))
        return m.unmarshal(source, Student.class).getValue();
    } catch (JAXBException e) {
        e.printStackTrace();
        return null;
    }   
}