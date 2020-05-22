@EnableAutoConfiguration
@RestController
public class SpringBootLoginController {

    @RequestMapping("/hello")
    String hello() {
        return "Hello World!!!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootLoginController.class, args);
    }
}