@Service
public class MyServiceService {

    @Autowired
    private RestTemplate restTemplate;

    private final String serviceUrl;

    public MyServiceService() {
        this.serviceUrl = "http://my-service";
    }

    public Map<String, String> getTest() {

        Map<String, Long> vars = new HashMap<>();
        vars.put("id", 1L);

        return restTemplate.postForObject(serviceUrl+"/test", vars, Map.class);
    }
}