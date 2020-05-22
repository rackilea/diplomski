public static <T> T jaxbXMLToObject(String xmlData, Class<T> clazz) {   //I've passed the xmlString to unmarshaller by StringReader
    try {
        T result = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        StreamSource source = new StreamSource(new StringReader(xmlData));
        result = unmarshaller.unmarshal(source, clazz).getValue();
        return result; // Ofcourse this is after conversion 
    } catch(JAXBException e) {
        // TODO - Handle Exception
    }
    return null;
}