static RootElement unmarshallXml(File xmlFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(RootElement.class, ElementBType.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    RootElement rootElement = (RootElement) jaxbUnmarshaller.unmarshal(xmlFile);
    return rootElement;
}