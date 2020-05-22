@Component
public class RestTemplateProvider {

    @Value("${endpoint-url}")
    private String endpointUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateProvider(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri(endpointUrl)
                .messageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }

    public RestTemplate provide() {
        return restTemplate;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }
}