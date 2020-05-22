import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

public static void main(String[] args) {

  try {

    Client client = Client.create();

    WebResource webResource = client
       .resource("http://JENKINS_HOST/job/JOBNAME/api");

    String input = "{\"key1\":\"value1\",\"key2\":\"value2\"}";

    ClientResponse response = webResource.type("application/json")
       .post(ClientResponse.class, input);

    if (response.getStatus() != 201) {
        throw new RuntimeException("Failed : HTTP error code : "
             + response.getStatus());
    }

    System.out.println("Output from Server .... \n");
    String output = response.getEntity(String.class);
    System.out.println(output);

  } catch (Exception e) {

    e.printStackTrace();

  }

 }
}