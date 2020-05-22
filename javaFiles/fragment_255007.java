@Configuration
public class GeneralConfiguration { 
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper()
           .registerModule(new ParameterNamesModule())
           .registerModule(new Jdk8Module())
           .registerModule(new JavaTimeModule());
        return mapper;
    }
}