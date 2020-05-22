@SpringBootApplication
@RestController
public class So53042903Application {

    public static void main(String[] args) {
        SpringApplication.run(So53042903Application.class, args);
    }

    @Autowired
    private IntegrationFlowContext flowContext;

    @RequestMapping(path = "/add/{name}", method = RequestMethod.GET)
    public String add(@PathVariable String name) {
        addFlow(name);
        System.out.println("added " + name);
        return "added " + name;
    }

    @RequestMapping(path = "/remove/{name}", method = RequestMethod.GET)
    public String remove(@PathVariable String name) {
        this.flowContext.remove(name);
        System.out.println("removed " + name);
        return "removed " + name;
    }

    private void addFlow(String name) {
        IntegrationFlow flow = IntegrationFlows.from(() -> "processing: " + name, e -> e
                    .poller(Pollers.fixedDelay(3_000)))
                .log(Level.INFO, "foo", "payload")
                .get();
        this.flowContext.registration(flow).id(name).register();
    }

}