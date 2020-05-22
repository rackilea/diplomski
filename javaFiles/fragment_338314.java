@Service
public class FooService {

    private final RestTemplate restTemplate;

    public FooService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getIndex() {
        String result = restTemplate.getForObject("http://localhost:8080", String.class);
        System.out.println("index: " + result);
        return result;
    }
}