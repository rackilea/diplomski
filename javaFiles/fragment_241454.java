import io.quarkus.test.common.http.TestHTTPResource;
    import io.quarkus.test.junit.QuarkusTest;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;

    import javax.json.bind.JsonbBuilder;
    import javax.ws.rs.client.Client;
    import javax.ws.rs.client.ClientBuilder;
    import javax.ws.rs.client.WebTarget;
    import javax.ws.rs.core.MediaType;
    import javax.ws.rs.sse.SseEventSource;
    import java.net.URL;
    import java.util.*;
    import java.util.concurrent.CompletableFuture;

    import static org.assertj.core.api.Assertions.assertThat;

    @QuarkusTest
    public class DBServiceTest {

      @TestHTTPResource("/addresses")
      private URL enpointUrl;

      @Test
      @DisplayName("Get all addresses")
      void testGetAddresses() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(String.valueOf(enpointUrl));
        try (SseEventSource source = SseEventSource.target(target).build()) {
          CompletableFuture<Collection<Address>> futureAddresses = new CompletableFuture<>();
          Set<Address> foundAddresses = new HashSet<>();
          source.register(
              event -> {
                if (!foundAddresses.add(
                    event.readData(Address.class, MediaType.APPLICATION_JSON_TYPE))) {
                  futureAddresses.complete(foundAddresses);
                }
              },
              Assertions::fail);
          source.open();
          Collection<Address> addresses = futureAddresses.join();
          assertThat(addresses).containsExactlyInAnyOrderElementsOf(readTestAdresses());
        }
      }

      private List<Address> readTestAdresses() {
        return JsonbBuilder.create()
            .fromJson(
                this.getClass().getResourceAsStream("test-addresses.json"),
                new ArrayList<Address>() {}.getClass().getGenericSuperclass());
      }
    }