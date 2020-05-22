public class ValidateUrl {

    private RestTemplate restTemplate;

    @Autowired
    public ValidateUrl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Integer validateUrl(String url, int timeOut) throws Exception {
     ...
    }
}