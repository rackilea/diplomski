import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.http.client.fluent.Async;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.concurrent.FutureCallback;

/**
 * Following libraries have been used:
 * 
 * 1) httpcore-4.4.5.jar
 * 2) httpclient-4.5.2.jar
 * 3) commons-logging-1.2.jar
 * 4) fluent-hc-4.5.2.jar     * 
 *
 */

public class AsyncRequestDemo {
    public static void main(String[] args) throws Exception {
    URIBuilder urlBuilder = new URIBuilder()
                               .setScheme("http")
                               .setHost("stackoverflow.com")
                               .setPath("/questions/38277471/fire-and-forget-for-http-in-java");

    final int nThreads = 3; // no. of threads in the pool
    final int timeout = 0; // connection time out in milliseconds

    URI uri = null;
    try {
        uri = urlBuilder.build();
    } catch (URISyntaxException use) {
        use.printStackTrace();
    }

    ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
    Async async = Async.newInstance().use(executorService);
    final Request request = Request.Get(uri).connectTimeout(timeout);

        Future<Content> future = async.execute(request, new FutureCallback<Content>() {
            public void failed(final Exception e) {
                System.out.println("Request failed: " + request);
                System.exit(1);
            }

            public void completed(final Content content) {
                System.out.println("Request completed: " + request);
                System.out.println(content.asString());
                System.exit(0);
            }

            public void cancelled() {
            }
        });

        System.out.println("Request submitted");

    }

}