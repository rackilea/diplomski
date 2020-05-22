import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class DELETEClient {
public static void main(String[] args) {
    Client client = ClientBuilder.newClient();

    WebTarget target = client.target("http://localhost:4848/management/domain/applications/application/hello");

    String responseData = target.request().header("Accept", "application/json").header("X-Requested-By", "Dummy").delete(String.class);
    Response response = target.request().delete();
    System.out.println(responseData);
    System.out.println(response);
}
}