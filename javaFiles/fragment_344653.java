@RestController
@EnableAutoConfiguration
public class TestSpring {

    @RequestMapping("/hello")
    String hello() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestSpring.class, args);
    }

}