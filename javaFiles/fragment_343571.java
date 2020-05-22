@RestController
public class TestController {

    @RequestMapping("/example")
    public String doAThing(@RequestParam("test") String test) throws MessagingException {
        return "Your variable is " + test;
    }
}