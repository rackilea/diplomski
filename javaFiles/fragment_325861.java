import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
/**
 *
 * @author Izak
 */
public class PostHTTP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(
            "http://mkpartners.force.com/services/apexrest/careers?firstName=Izak&lastName=Tarashandegan&email=izaktarashandegan@gmail.com");
                String json = "{\"application\":{\"isTest\":true,\"firstName\":\"Izak\",\"lastName\":\"Tarashandegan\",\"email\":\"izaktarashandegan@gmail.com\",\"phone\":\"4244420591\",\"zipcode\":\"90035\",\"describeYourself\":\"I am passionate about programming.I do my best to learn new materials about programming everyday. My favorite language is Java, and I do all my coding in Java.\",\"skills\":[\"I can talk in English and Farsi fluently, and I know a little Spanish too\"],\"education\":[{\"school\":\"CSUN\",\"graduationYear\":2013,\"degree\":\"bachelor\",\"major\":\"CS\"},{\"school\":\"SMC\",\"graduationYear\":2010,\"degree\":\"AA\",\"major\":\"CS\"}],\"experience\":[{\"company\":\"Ambient Digital Media\",\"fromDate\":\"2004-02-01\",\"toDate\":\"2004-05-01\",\"title\":\"web desinger\",\"workDone\":\"update their website\"},{\"company\":\"liberty plumbing and heating Inc.\",\"fromDate\":\"2004-06-01\",\"toDate\":\"2013-05-15\",\"title\":\"web desinger\",\"workDone\":\"work as a book keeper\"}]}}";
        StringEntity input = new StringEntity(json);
        input.setContentType("application/json");
        postRequest.setEntity(input);

        HttpResponse response = httpClient.execute(postRequest);

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = 
                   new BufferedReader(new InputStreamReader(response.getEntity().getContent()), 65728);
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }


System.out.println("finalResult " + sb.toString());
        System.out.println(response.getStatusLine().getReasonPhrase());

        if (response.getStatusLine().getStatusCode() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                + response.getStatusLine().getStatusCode());
        }

        BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        httpClient.getConnectionManager().shutdown();

      } catch (MalformedURLException e) {

        e.printStackTrace();

      } catch (IOException e) {

        e.printStackTrace();

      }
    }

}