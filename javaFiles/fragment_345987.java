@Component
public class MyService {

    private final RSocketRequester rsocketRequester;

    public MyService(RSocketRequester.Builder builder) {
        this.rsocketRequester = builder
                .connectWebSocket(URI.create("ws://localhost:8080/rsocket"))
                .block();
    }
}