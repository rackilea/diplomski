@RestController
public class GreetingController {

  private static final Logger LOG = LoggerFactory.getLogger(GreetingController.class);

  private static final String template = "Hello, %s!";

  private final Counter counter;

  public GreetingController(MeterRegistry meterRegistry) {
    counter = meterRegistry.counter("my.counter");
  }


  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

    counter.increment();
    long count = (long) counter.count();

    return new Greeting(count, String.format(template, name));
  }
}