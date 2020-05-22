@Configuration
public class ConfigurationBean {
    @Bean
    public Configuration configuration() {
        return new Configuration();
    }

    @Bean
    public Template template() {
        return configuration().getTemplate("...");
    }
}