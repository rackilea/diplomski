@Configuration
public class JacksonConfiguration {

    @Value("${customValue}")
    private int myCustomValue;

    @Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper mapper = new ObjectMapper();

        final SimpleModule module = new SimpleModule();

        module.addSerializer(new Deserializer(myCustomValue));
        mapper.registerModule(module);

        return mapper;
    }
}