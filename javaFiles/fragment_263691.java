public class JSONUtil {
    private ObjectMapper mapper = new ObjectMapper();

    public JSONUtil() {
        super();
        // Set ObjectMapper configuration and properties here
    }

    public <T> T deserialize(final String response, final Class<T> responseClass) {
        if(response == null || responseClass == null) return null;

        return mapper.readValue(response, responseClass);
    }
}