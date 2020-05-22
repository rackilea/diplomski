@Configuration
public class Configuration {

    @Bean
    public MappingJackson2HttpMessageConverter camelCaseConverter() {
        MappingJackson2HttpMessageConverter converter = new CustomConverter("package.camel");
        converter.setObjectMapper(camelCaseObjectMapper());
        return converter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter snakeCaseConverter() {
        MappingJackson2HttpMessageConverter converter = new CustomConverter("package.snake");
        converter.setObjectMapper(snakeCaseObjectMapper());
        return converter;
    }

    @Bean
    public ObjectMapper camelCaseObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);

        return mapper;
    }

    @Bean
    public ObjectMapper snakeCaseObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        return mapper;
    }
}