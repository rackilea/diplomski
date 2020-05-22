@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public StudentMapperImpl studentMapper() {
        return new StudentMapperImpl ();
    }
}