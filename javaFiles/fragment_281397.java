@Component
public class InstanceListener implements ApplicationListener<HeartbeatEvent> {

    @Autowired
    private CustomerWebService customerWebService;

    @Override
    public void onApplicationEvent(HeartbeatEvent event) {
        Mono<String> result = customerWebService.findById("id");
        result.subscribe(
                value -> System.out.println(value),
                error -> error.printStackTrace()
        );
    }
}