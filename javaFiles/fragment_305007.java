import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.iam.v1.Iam;
import com.google.api.services.iam.v1.IamScopes;
import com.google.api.services.iam.v1.model.CreateServiceAccountKeyRequest;
import com.google.api.services.iam.v1.model.ServiceAccountKey;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class IamDemo {
  /** Name of the application. */
  private static final String APPLICATION_NAME = "IamDemoJava";

  /** Project Name. */
  private static final String PROJECT_NAME = "MY_PROJECT_NAME";

  /** Name of the service account to create a new key for. */
  private static final String SERVICE_ACCOUNT_NAME = "dummy-sa";

  /** Full email address of the service account. */
  private static final String SERVICE_ACCOUNT_EMAIL =
      SERVICE_ACCOUNT_NAME + "@" + PROJECT_NAME + ".iam.gserviceaccount.com";

  /** Full service account resource string expected by the IAM API. */
  private static final String SERVICE_ACCOUNT_RESOURCE_NAME =
      "projects/" + PROJECT_NAME + "/serviceAccounts/" + SERVICE_ACCOUNT_EMAIL;

  /** Global instance of the HTTP transport. */
  private static HttpTransport httpTransport;

  /** Global instance of the JSON factory. */
  private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

  public static void main() throws IOException, GeneralSecurityException {
    Iam iam = initIam();
    ServiceAccountKey key = createServiceAccountKey(iam);

    // Print the key
    System.out.println(key.toString());
  }

  private static Iam initIam() throws IOException, GeneralSecurityException {
    httpTransport = GoogleNetHttpTransport.newTrustedTransport();

    // Authenticate using Google Application Default Credentials.
    GoogleCredential credential = GoogleCredential.getApplicationDefault();


    if (credential.createScopedRequired()) {
      List<String> scopes = new ArrayList<>();
      // Enable full Cloud Platform scope.
      scopes.add(IamScopes.CLOUD_PLATFORM);
      credential = credential.createScoped(scopes);
    }

    // Create IAM API object associated with the authenticated transport.
    return new Iam.Builder(httpTransport, JSON_FACTORY, credential)
        .setApplicationName(APPLICATION_NAME)
        .build();
  }

  private static ServiceAccountKey createServiceAccountKey(Iam iam)
      throws IOException, GeneralSecurityException {
    CreateServiceAccountKeyRequest request = new CreateServiceAccountKeyRequest();

    // Customize the request parameters if needed

    return iam.projects()
        .serviceAccounts()
        .keys()
        .create(SERVICE_ACCOUNT_RESOURCE_NAME, request)
        .execute();
  }
}