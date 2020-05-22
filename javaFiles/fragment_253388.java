@SpringBootConfiguration
@EnableAutoConfiguration
// Or just @SpringBootApplication instead of the 2 above
@Import(AppConfig.class)
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }
}