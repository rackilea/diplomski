import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;
import java.util.List;

public class CustomSubscriber {

  public static void main(String[] args) {
    CustomSubscriber cs = new CustomSubscriber();
    String body = cs.get(args[0]).join();
    System.out.println("--- Response body:\n: ..." + body + "...");
  }

  public CompletableFuture<String> get(String uri) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .build();

    return client.sendAsync(request, responseInfo -> new StringSubscriber())
        .whenComplete((r, t) -> System.out.println("--- Status code " + r.statusCode()))
        .thenApply(HttpResponse::body);
  }

  static class StringSubscriber implements BodySubscriber<String> {

    final CompletableFuture<String> bodyCF = new CompletableFuture<>();
    Flow.Subscription subscription;
    List<ByteBuffer> responseData = new CopyOnWriteArrayList<>();

    @Override
    public CompletionStage<String> getBody() {
      return bodyCF;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
      this.subscription = subscription;
      subscription.request(1); // Request first item
    }

    @Override
    public void onNext(List<ByteBuffer> buffers) {
      System.out.println("-- onNext " + buffers);
      try {
        System.out.println("\tBuffer Content:\n" + asString(buffers));
      } 
      catch (Exception e) {
        System.out.println("\tUnable to print buffer content");
      }
      buffers.forEach(ByteBuffer::rewind); // Rewind after reading
      responseData.addAll(buffers);
      subscription.request(1); // Request next item
    }

    @Override
    public void onError(Throwable throwable) {
      bodyCF.completeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
      bodyCF.complete(asString(responseData));
    }

    private String asString(List<ByteBuffer> buffers) {
      return new String(toBytes(buffers), StandardCharsets.UTF_8);
    }

    private byte[] toBytes(List<ByteBuffer> buffers) {
      int size = buffers.stream()
          .mapToInt(ByteBuffer::remaining)
          .sum();
      byte[] bs = new byte[size];
      int offset = 0;
      for (ByteBuffer buffer : buffers) {
        int remaining = buffer.remaining();
        buffer.get(bs, offset, remaining);
        offset += remaining;
      }
      return bs;
    }

  }
}