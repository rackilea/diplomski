@SpringBootApplication
public class So45583717Application {

    public static void main(String[] args) {
        SpringApplication.run(So45583717Application.class, args);
    }

    @RestController
    @RequestMapping("/")
    public static class Ctrl {

        @PostMapping
        public String post(@RequestBody Integer userId) {
            return "UserId is: " + userId;
        }
    }
}