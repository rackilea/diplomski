@SpringBootApplication
@ComponentScan("webservices")
public class Application {

    @Bean
    public LinkedBlockingQueue<RawDate> queue() {
        return new LinkedBlockingQueue<>();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        Application app = new Application(ctx);
        // do other stuff here
    }
}

@RestController
public class GoogleTokenController {
    @Autowired // Let Spring inject the queue
    private LinkedBlockingQueue<RawData> queue;

    @CrossOrigin
    @RequestMapping(value = "/google/token", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    @ResponseBody    
    public String googleToken(@RequestBody AuthCode authCode) {
        System.out.println("CODE: " + authCode.getAuthCode());
        // do other stuff here
        return "OK";
    }
}