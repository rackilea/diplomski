@Slf4j
@Component
public class MyClient {

    private final WebClient webClient;

    // Create WebClient instance using builder.
    // If you use spring-boot 2.0, the builder will be autoconfigured for you
    // with the "prototype" scope, meaning each injection point will receive
    // a newly cloned instance of the builder.
    public MyClient(WebClient.Builder webClientBuilder) {
        webClient = webClientBuilder // you can also just use WebClient.builder()
                .baseUrl("https://httpbin.org")
                .filter(logRequest()) // here is the magic
                .build();
    }

    // Just example of sending request
    public void send(String path) {
        ClientResponse clientResponse = webClient
                .get().uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam("param", "value")
                        .build())
                .exchange()
                .block();
        log.info("Response: {}", clientResponse.toEntity(String.class).block());
    }

    // This method returns filter function which will log request data
    private static ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
            return Mono.just(clientRequest);
        });
    }

}