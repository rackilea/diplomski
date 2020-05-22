@RestController
class MyController {

    @Autowired
    private AnyComponent anyComponent;

    @GetMapping("/")
    public String sayHello() {
        anyComponent.invokeCoach();

        return "Time on server is: " + new java.util.Date();
    }

}