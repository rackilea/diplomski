public class TestBean {
    private String name;
    private int id;
    //getters and setters
}

public interface TestBeanMixin {
    @JsonProperty("short_field_name")
    String getName();
    @JsonProperty("short_field_id")
    int getId();
}

@Provider
@Priority(1)
public class MixInJacksonJsonProvider extends JacksonJaxbJsonProvider {
    private static final ObjectMapper mapper = createMapper();

    public MixInJacksonJsonProvider() {
        setMapper(mapper);
    }

    private static ObjectMapper createMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.addMixIn(TestBean.class, TestBeanMixin.class);
        return result;
    }
}