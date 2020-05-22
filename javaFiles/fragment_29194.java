@Service
public class SomeService {

private EndpointUrlProvider endpointUrlProvider;
private RestTemplate restTemplate;

@Autowired
public SomeService(EndpointUrlProvider endpointUrlProvider, RestTemplate restTemplate){
  this.endpointUrlProvider = endpointUrlProvider;
  this.restTemplate = restTemplate;
}