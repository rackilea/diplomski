@RestController    
public class ExampleController {
private static final Log LOGGER = LogFactory.getLog(ExampleController.class);

@RequestMapping("/<custom-url>")
public String function() {
    String message = "Example message written to the log";
    String secondMessage = "Second example written to the log";
    LOGGER.info(message);
    LOGGER.info(secondMessage);
    return message;
}
}