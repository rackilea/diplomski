import java.io.*;
import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.*;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.*;
import org.apache.http.protocol.*;

// ...
PoolingHttpClientConnectionManager cm =
        new PoolingHttpClientConnectionManager();
cm.setMaxTotal(200); // increase max total connection to 200
cm.setDefaultMaxPerRoute(20); // increase max connection per route to 20
CloseableHttpClient httpClient = HttpClients.custom()
        .setConnectionManager(cm)
        .build();

String[] urisToGet = { ... };
// start a thread for each URI
// (if there are many URIs, a thread pool would be better)
Thread[] threads = new Thread[urisToGet.length];
for (int i = 0; i < threads.length; i++) {
    HttpGet httpget = new HttpGet(urisToGet[i]);
    threads[i] = new Thread(new GetTask(httpClient, httpget));
    threads[i].start();
}
// wait for all the threads to finish
for (int i = 0; i < threads.length; i++) {
    threads[i].join();
}

class GetTask implements Runnable {
    private final CloseableHttpClient httpClient;
    private final HttpContext context;
    private final HttpGet httpget;

    public GetTask(CloseableHttpClient httpClient, HttpGet httpget) {
        this.httpClient = httpClient;
        this.context = HttpClientContext.create();
        this.httpget = httpget;
    }

    @Override
    public void run() {
        try {
            CloseableHttpResponse response = httpClient.execute(
                httpget, context);
            try {
                HttpEntity entity = response.getEntity();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException ex) {
            // handle protocol errors
        } catch (IOException ex) {
            // handle I/O errors
        }
    }
}