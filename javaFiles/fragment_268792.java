@SpringBootApplication
  @ComponentScan("com.ma.demospringboot")
  @EnableJpaRepositories("com.ma.demospringboot.repository")
  @EntityScan(basePackages = "com.ma.demospringboot.domain")
  public class DemoSpringBootApp {
      //your current code here
  }