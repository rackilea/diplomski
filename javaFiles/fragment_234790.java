@Component
public class Service {

    private RestTemplate restTemplate;  

    @Autowired 
    public Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isEnabled(String xxx) {
        ResponseEntity<String> response = restTemplate.getForEntity("someurl",String.class);
        if(...)return true;
        return false;
    }
}