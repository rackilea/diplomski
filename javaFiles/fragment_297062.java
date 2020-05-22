// ...
import com.google.api.client.auth.oauth2.Credential;
import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.util.ServiceException;
// ...
import java.io.IOException;
import java.net.URL;
// ...

public class MyClass {
  // …

  /**
   * Print document entries using the provided authorized DocsService.
   * 
   * @param credential OAuth 2.0 credential to use to authorize the requests.
   * @throws IOException
   * @throws ServiceException
   */
  static void printDocuments(Credential credential) throws IOException, ServiceException {
    // Instantiate and authorize a new DocsService object.
    DocsService service = new DocsService("<YOUR_APPLICATION_NAME>");
    service.setOAuth2Credentials(credential);

    // Send a request to the Documents List API to retrieve document entries.
    URL feedUri = new URL("https://docs.google.com/feeds/default/private/full/");
    DocumentListFeed feed = service.getFeed(feedUri, DocumentListFeed.class);

    for (DocumentListEntry entry : feed.getEntries()) {
      System.out.println("Title: " + entry.getTitle().getPlainText());
    }
  }

  // ...
}