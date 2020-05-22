import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class CloseableHttpClientTryWithResources {

    public static void main(String... args) throws Exception {

        URIBuilder uriBuilder = new URIBuilder("https://www.google.com/");

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        CloseableHttpClient client = HttpClients.custom().build();

        try (CloseableHttpResponse response = client.execute(httpGet)) {

            response.getEntity().writeTo(System.out);

        } catch (IOException e) {

            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
    }
}