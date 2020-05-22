@Configuration
public class SingletonWrapperConfig {
    @Bean
    public JacksonMapper jacksonMapper() {
        return JacksonMapper.getInstance();
    }
}