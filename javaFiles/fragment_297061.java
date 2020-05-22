import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MyClass {

  // Retrieve the CLIENT_ID and CLIENT_SECRET from an APIs Console project:
  //     https://code.google.com/apis/console
  static String CLIENT_ID = "<YOUR_CLIENT_ID>";
  static String CLIENT_SECRET = "<YOUR_CLIENT_SECRET>";
  // Change the REDIRECT_URI value to your registered redirect URI for web
  // applications.
  static String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
  // Add other requested scopes.
  static List<String> SCOPES = Arrays.asList("https://docs.google.com/feeds");

  /**
   * Retrieve OAuth 2.0 credentials.
   * 
   * @return OAuth 2.0 Credential instance.
   */
  static Credential getCredentials() throws IOException {
    HttpTransport transport = new NetHttpTransport();
    JacksonFactory jsonFactory = new JacksonFactory();

    // Step 1: Authorize -->
    String authorizationUrl =
        new GoogleAuthorizationCodeRequestUrl(CLIENT_ID, REDIRECT_URI, SCOPES).build();

    // Point or redirect your user to the authorizationUrl.
    System.out.println("Go to the following link in your browser:");
    System.out.println(authorizationUrl);

    // Read the authorization code from the standard input stream.
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("What is the authorization code?");
    String code = in.readLine();
    // End of Step 1 <--

    // Step 2: Exchange -->
    GoogleTokenResponse response =
        new GoogleAuthorizationCodeTokenRequest(transport, jsonFactory, CLIENT_ID, CLIENT_SECRET,
            code, REDIRECT_URI).execute();
    // End of Step 2 <--

    // Build a new GoogleCredential instance and return it.
    return new GoogleCredential.Builder().setClientSecrets(CLIENT_ID, CLIENT_SECRET)
        .setJsonFactory(jsonFactory).setTransport(transport).build()
        .setAccessToken(response.getAccessToken()).setRefreshToken(response.getRefreshToken());
  }

  // …
}