import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;


public class DriveCommandLine {


  private static String SERVICE_ACCOUNT_EMAIL  = "11111-abc123@developer.gserviceaccount.com";
  private static final String SERVICE_ACCOUNT_PKCS12_FILE_NAME = "a_file_name.p12";
  private static String SERVICE_ACCOUNT_PKCS12_FILE_PATH; 

  public static void main(String[] args) throws IOException {
    try {
      //I did this stuff for the p12 file b/c I was having trouble doing this all from command line (first time)
      URL location = DriveCommandLine.class.getProtectionDomain().getCodeSource().getLocation();
      SERVICE_ACCOUNT_PKCS12_FILE_PATH = location.getFile() + SERVICE_ACCOUNT_PKCS12_FILE_NAME;

      Drive drive = DriveCommandLine.getDriveService("valid-user@example.com");
      DriveCommandLine.printFile(drive, "THE_ID_OF_THE_FILE");
    } catch (GeneralSecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  //From https://developers.google.com/drive/web/delegation#instantiate_a_drive_service_object
  /**
   * Build and returns a Drive service object authorized with the service accounts
   * that act on behalf of the given user.
   *
   * @param userEmail The email of the user.
   * @return Drive service object that is ready to make requests.
   */
  public static Drive getDriveService(String userEmail) throws GeneralSecurityException, IOException {
    HttpTransport httpTransport = new NetHttpTransport();
    JacksonFactory jsonFactory = new JacksonFactory();
    GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
                                                                .setJsonFactory(jsonFactory)
                                                                .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
                                                                .setServiceAccountScopes(Arrays.asList(new String[] {DriveScopes.DRIVE}))
                                                                .setServiceAccountUser(userEmail)
                                                                .setServiceAccountPrivateKeyFromP12File(new java.io.File(SERVICE_ACCOUNT_PKCS12_FILE_PATH))
                                                                .build();
    Drive service = new Drive.Builder(httpTransport, jsonFactory, null).setHttpRequestInitializer(credential).build();
    return service;
  }
  // From the code box at https://developers.google.com/drive/v2/reference/files/get
  /**
   * Print a file's metadata.
   *
   * @param service Drive API service instance.
   * @param fileId ID of the file to print metadata for.
   */
  private static void printFile(Drive service, String fileId) {

    try {
      File file = service.files().get(fileId).execute();

      System.out.println("Title: " + file.getTitle());
      System.out.println("Description: " + file.getDescription());
      System.out.println("MIME type: " + file.getMimeType());
    } catch (IOException e) {
      System.out.println("An error occured: " + e);
    }
  }
}