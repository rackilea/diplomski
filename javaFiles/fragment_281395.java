@Service
public class CustomerWebService {

    private static final String CUSTOMERS_WITH_ID = "/customers/{id}";
    private static final String CUSTOMER_ROOT_ENDPOINT = "/customers";

    private String baseUrl = "lb://customer-service/customers";

    @LoadBalanced
    private final WebClient.Builder webClient;

    public CustomerWebService(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    public Mono<String> findById(String id) {
        return webClient.build()
                .get()
                .uri(baseUrl, id)
                .retrieve()
                .bodyToMono(String.class);
    }
}