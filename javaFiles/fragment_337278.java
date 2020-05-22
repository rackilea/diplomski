@Profile("CMD")
@SpringBootApplication
@EnableAutoConfiguration
public class JobApplication implements CommandLineRunner {
  Logger logger = LoggerFactory.getLogger(JobApplication.class);


  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(JobApplication.class, args);
    context.close();
  }

  @Override
  public void run(String... args) throws Exception {
    // run the job
  }
}


@Profile("WEB")
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}