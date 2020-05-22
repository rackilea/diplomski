import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.tomakehurst.wiremock.WireMockServer;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.lanwen.wiremock.ext.WiremockResolver;
import ru.lanwen.wiremock.ext.WiremockResolver.Wiremock;
import ru.lanwen.wiremock.ext.WiremockUriResolver;
import ru.lanwen.wiremock.ext.WiremockUriResolver.WiremockUri;

@ExtendWith({
  WiremockResolver.class,
  WiremockUriResolver.class
})
public class ReactiveThreadsControlTest {

  private static int concurrency = 1;

  private final WebClient webClient = WebClient.create();

  @Test
  public void slowServerResponsesTest(@Wiremock WireMockServer server, @WiremockUri String uri) {

    String requestUri = "/slow-response";

    server.stubFor(get(urlEqualTo(requestUri))
      .willReturn(aResponse().withStatus(200)
        .withFixedDelay((int) TimeUnit.SECONDS.toMillis(2)))
    );

    Flux
      .generate(() -> Integer.valueOf(1), (i, sink) -> {
        System.out.println(String.format("[%s] Emitting next value: %d", Thread.currentThread().getName(), i));
        sink.next(i);
        return i + 1;
      })
      .subscribeOn(Schedulers.single())
      .flatMap(i ->
          executeGet(uri + requestUri)
            .publishOn(Schedulers.elastic())
            .map(response -> {
              heavyTask();
              return true;
            })
        , concurrency)
      .subscribe();

    blockForever();
  }

  private void blockForever() {
    Object monitor = new Object();

    synchronized (monitor) {
      try {
        monitor.wait();
      } catch (InterruptedException ex) {
      }
    }
  }


  private Mono<ClientResponse> executeGet(String path) {
    System.out.println(String.format("[%s] About to execute an HTTP GET request: %s", Thread.currentThread().getName(), path));
    return webClient
      .get()
      .uri(path)
      .exchange();
  }

  private void heavyTask() {
    try {
      System.out.println(String.format("[%s] About to execute a heavy task", Thread.currentThread().getName()));
      Thread.sleep(TimeUnit.SECONDS.toMillis(20));
    } catch (InterruptedException ex) {
    }
  }
}