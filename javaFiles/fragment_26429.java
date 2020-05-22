import java.util.concurrent.Future;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.scheduling.annotation.EnableAsync;

    @SpringBootApplication
    @EnableAsync
    public class Application implements CommandLineRunner {

        @Autowired
        SampleService sampleService;

        @Override
        public void run(String... args) throws Exception {
            Future page1 = sampleService.sendEmail("test@gmail.com");
            while (!page1.isDone()) {
                Thread.sleep(10);
            }
            System.out.println(page1.get());
        }

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }