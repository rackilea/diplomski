@SpringBootApplication
@EnableWebSecurity
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public SSHParser sshParser() {
    SSHParser parser = new SSHParser();
    parser.startParserLoop();
    return parser;
  }

}