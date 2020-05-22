import org.codehaus.jackson.map.type.TypeFactory;

//...

@SuppressWarnings({ "deprecation", "rawtypes" })
public static <E, T extends Collection> T parseJsonToObject(String jsonStr, Class<T> collectionType, Class<E> elementType) {
    ObjectMapper mapper = new ObjectMapper();
    try {
        return mapper.readValue(jsonStr, TypeFactory.collectionType(collectionType, elementType));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null; 
}