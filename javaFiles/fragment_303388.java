@Configuration
public class BeanConfig {

    @Bean
    public Magician magician() {
        return new Magician();
    }
...