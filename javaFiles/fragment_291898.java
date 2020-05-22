public List getObjects(Class<T> aClass, File file) throws ClassNotFoundException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    //Fetches Arrayed Class
    Class namedClass = Class.forName("[L" + aClass.getName() + ";");
    List myObjects = Arrays.asList(mapper.readValue(file, namedClass));
    return myObjects;
}