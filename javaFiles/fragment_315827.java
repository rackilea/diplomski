/**
 * This controller is used only for testing purposes.
 * Especially to check if the JWT authentication is ok.
 */
@RestController
public class TestController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String testEndpoint() {
        return "Hello World!";
    }
}