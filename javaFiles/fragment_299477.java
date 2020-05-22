public static Object unMarshaller(JAXBContext jc,byte[] byteArr) throws JAXBException{
        Unmarshaller u = jc.createUnmarshaller();
        ByteArrayInputStream bais = new ByteArrayInputStream(byteArr);
        u.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
        Source input = new StreamSource(bais);
        return u.unmarshal(input);
    }