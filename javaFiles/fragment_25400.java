@SpringBootApplication
public class TestApplication {
public static void main(final String[] args) {
    final SpringApplication app = new SpringApplication(TestApplication.class);
    app.run(args);
}
}