@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan("com.buhryn.interviewer.models")
public class Application {

    public static void main(String[] args) {
        System.out.println("--------------------------- Start Application ---------------------------");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}