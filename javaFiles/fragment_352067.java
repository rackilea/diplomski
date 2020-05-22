public void unmarshal() throws FileNotFoundException{
    Unmarshaller unmarshaller;
    try {
        JAXBContext ctx = JAXBContext.newInstance(ObjectFactory.class);
        unmarshaller = ctx.createUnmarshaller();
        FileInputStream is = new FileInputStream("path/to/some.xml");
        SomeClass sc = (SomeClass) unmarshaller.unmarshal(is);
        System.out.println("title is: "+sc.getValue().getTitle());
    } catch (JAXBException e) {e.printStackTrace();}
}