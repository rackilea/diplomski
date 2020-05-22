@Component
public class JacksonConfiguration {

    @Autowired
    private EmptyToNullCustomDeserializer emptyToNullCustomDeserializer;

    @Primary
    @Bean
    public Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder(List<Jackson2ObjectMapperBuilderCustomizer> customizers) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        for (Jackson2ObjectMapperBuilderCustomizer customizer : customizers) {
            customizer.customize(builder);
        }
        return builder;
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addEmptyToNullStringDeserialization() {
        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder.deserializerByType(String.class, emptyToNullCustomDeserializer);
            }

        };
    }
}