public class ApplicationJSONProvider extends JacksonJsonProvider {
    private static ObjectMapper mapper = new ObjectMapper();

    public ApplicationJSONProvider() {
        super(mapper, BASIC_ANNOTATIONS);
        mapper.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS, true);