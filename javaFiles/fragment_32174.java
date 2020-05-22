@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(SampleApplication.class).web(false).run(args);
    }

}