@Configuration
public class DemoConfig {

    @Bean
    public Person adam() {
        return new Person("Adam");
    }

    @Bean
    public Person jacobs() {
        return new Person("Jacobs");
    }
}