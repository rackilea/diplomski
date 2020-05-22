public class JacksonMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final JacksonMapper INSTANCE;

    static 
    {
        INSTANCE = new JacksonMapper();
    }

    private JacksonMapper() {
        // not called
    }

    public static JacksonMapper getInstance() {

        return INSTANCE;
    }

    public Map<String, String> toMap(String jsonString) throws Exception {

        return mapper.readValue(jsonString, new TypeReference<HashMap<String, String>>(){});

   }    
}