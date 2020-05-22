@EnableAutoConfiguration
@RestController
public class GreetingController {
    @GetMapping(value = "/gJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public MyPojo gJson() {
        return new MyPojo("Windows 10", System.currentTimeMillis());
    }
}