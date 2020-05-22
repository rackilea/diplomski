public static <T> T fromXml(Class<T> clazz, String xml) {
    try {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller um = context.createUnmarshaller();
        Object obj = um.unmarshal(new StringReader(xml));
        try {
            return clazz.cast(obj);
        } catch (ClassCastException exc) {
             throw new RelevantException(
                 "Expected class "+clazz+
                  " but was "+obj.getClass()
             );
        }
    } catch (JAXBException exc) {
        throw new RelevantException(
            "Error unmarshalling XML response",
            exc
         );
    }
}