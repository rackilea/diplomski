import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.HttpClients;
import java.io.File;
import java.net.URI;

public class EnrollSpeaker {
    static String API_KEY = "YOUR-KEY";
    static String PROFILE_ID = "YOUR-PROFILE-ID";
    static String LOCATION = "westus"; // Check, might be different in the future 

    public static void main(String[] args) {
        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder(
                String.format("https://%s.api.cognitive.microsoft.com/spid/v1.0/identificationProfiles/%s/enroll", LOCATION, PROFILE_ID));
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", API_KEY);
            request.setEntity(new FileEntity(new File("test.wav"), ContentType.APPLICATION_OCTET_STREAM));

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            // Response is empty on success; the following will contain the URI where you can check the status
            System.out.println(response.getHeaders("Operation-Location")[0].getValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}