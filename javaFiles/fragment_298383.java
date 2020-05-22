private <T> T getResponseObject(String stubbedXmlFile, 
                                Class<T> jaxbInterfaceClass, 
                                AbstractRepository repository) {
    T responseObject = null;
    // code as before
    responseObject = (T) u.unmarshal(byteStream);

    return responseObject;
}