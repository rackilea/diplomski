Map<String, Object> jaxbConfig = new HashMap<String, Object>(); 
// initialize our custom reader
TransientAnnotationReader reader = new TransientAnnotationReader();
try {
    reader.addTransientField(Throwable.class.getDeclaredField("stackTrace"));
    reader.addTransientMethod(Throwable.class.getDeclaredMethod("getStackTrace"));
} catch (SecurityException e) {
    throw new RuntimeException(e);
} catch (NoSuchMethodException e) {
    throw new RuntimeException(e);
} catch (NoSuchFieldException e) {
    throw new RuntimeException(e);
}
jaxbConfig.put(JAXBRIContext.ANNOTATION_READER, reader); 

JAXBContext jc = JAXBContext.newInstance(new Class[] {jaxbObj.getClass()},jaxbConfig);