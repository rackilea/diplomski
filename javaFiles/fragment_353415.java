@RestController
public class ClientDemo {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/show-error")
    public String createError() {

        try{
            return restTemplate.getForEntity("http://localhost:8080/error", String.class).getBody();
        } catch(HttpClientErrorException | HttpServerErrorException ex) {
            return ex.getResponseBodyAsString();
        }
    }
}