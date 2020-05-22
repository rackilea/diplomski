private RestTemplate restTemplate;

@Autowired
public HelloController(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
}