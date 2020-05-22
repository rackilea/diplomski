@SpringBootApplication
public class CodeWarsApplication {

@Autowired
private CodeChallenges codechallenge;    

public static void main(String[] args) {   
    SpringApplication.run(CodeWarsApplication.class, args);
}

  @EventListener(ApplicationReadyEvent.class)
  public void callTestMethod() {
      codechallenge.testMethod();   
  }
}