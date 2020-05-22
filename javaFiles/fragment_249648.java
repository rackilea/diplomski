@SpringBootApplication
    public class ReTestsApplication implements CommandLineRunner {

        public static void main(String[] args) {
            SpringApplication application = new SpringApplication(ReTestsApplication.class);
            application.setWebEnvironment(false);
            application.setBannerMode(Banner.Mode.OFF);
            application.run(args);
        }

        public void run(String... args) throws Exception {

        }
    }