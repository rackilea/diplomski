@RestController
public class SampleController {

    private final ConfigClass config;

    public SampleController(ConfigClass configClass) { // <- request the object of type ConfigClass
        this.config = configClass; // <- set the value for later usage
    }

    @RequestMapping(value = "test")
    public String test() {
        return config.getAccessKey();  // <- use the object of type ConfigClass
    }
}