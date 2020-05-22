public class SerializationUtil {
    private static ObjectMapper normalObjectMapper;
    private static ObjectMapper wrappedObjectMapper;

    static {
        /* configure different (de)serialization strategies */
        normalObjectMapper = new ObjectMapper();
        wrappedObjectMapper = new ObjectMapper();
        wrappedObjectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        wrappedObjectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    }

    public static <T> T normalDeserialize(String json, Class<T> clazz) throws Exception {
        return normalObjectMapper.readValue(json, clazz);
    }

    public static String normalSerialize(Object bean) throws Exception {
        return normalObjectMapper.writeValueAsString(bean);
    }

    public static <T> T deserializeWrappedObject(String json, Class<T> clazz) throws Exception {
        return wrappedObjectMapper.readValue(json, clazz);
    }

    public static String serializeWrappedObject(Object bean) throws Exception {
        return wrappedObjectMapper.writeValueAsString(bean);
    }
}