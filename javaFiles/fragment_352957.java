public <T> JAXBElement<T> getJaxbElement (Object obj, Class<T> clazz){
    ObjectFactory objectFactory = getObjectFactory();
    String methodName = "create" +  clazz.getName();
    Method m = objectFactory.getClass().getDeclaredMethod(methodName, clazz);
    Object ret = m.invoke(objectFactory, obj);
    return (JAXBElement<T>) ret;
}