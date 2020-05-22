@RestController
public class ControllerImpl {
    @Autowired
    Greeter greeter;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
        return greeter.greet();
    }
}