import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

public class RestClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("https://<api-base-url>/<resource-path>");

        Response response = target.request().options();
        Map<String, List<String>> headerMap = response.getStringHeaders();

        for (String key : headerMap.keySet()) {
            List<String> values = headerMap.get(key);
            for (String value : values) {
                // The header and its corresponding value can be processed as per the case.
            }
        }

        // This will return a list of all supported HTTP Methods (GET, POST, PUT, ..., etc)
        List<String> httpMethods = headerMap.get("Allow");

        for (String method : httpMethods) {
            if ("GET".equals(method)) {
                // Do something
            }

            if ("POST".equals(method)) {
                // Do something
            }
            ...
            ...
        }

        response.close();
    }
}