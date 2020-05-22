@RestController
public class DemoController {

    @GetMapping("/hello")
    String hello(){
        return "Message from controller if there is no exception";
    }
}