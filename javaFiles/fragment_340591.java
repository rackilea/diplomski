@SpringBootApplication
@ComponentScan(basePackageClasses = {"my.pkg.config", "my.pkg.example"})
public class Application {

  public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
  }
}