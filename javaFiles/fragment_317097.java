public static void main(String[] args) throws Exception {
    File file = new File("xml.xml");

    JAXBContext jaxbContext = JAXBContext.newInstance(Save.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    Save load = (Save) jaxbUnmarshaller.unmarshal(file);

    for (String parts : load.getPartsList())
        System.out.println(parts);
}