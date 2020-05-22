import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.model.User;
import com.google.api.services.admin.directory.model.UserName;

public class DirectoryUtils {

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport httpTransport;

    public static Directory initDirectory() throws GeneralSecurityException, IOException {
        httpTransport = GoogleNetHttpTransport.newTrustedTransport();

        Credential credential = null; // TODO initialize credentials

        Directory directory = new Directory.Builder(httpTransport, JSON_FACTORY, credential)
        .setApplicationName("My App Name")
        .build();

        return directory;
    }

    public static User createUser(Directory directory) throws IOException {
        User user = new User();
        // populate are the required fields only
        UserName name = new UserName();
        name.setFamilyName("Blogs");
        name.setGivenName("Jo");
        user.setName(name);
        user.setPassword("password101");
        user.setPrimaryEmail("jo.blogs@example.com");

        // requires DirectoryScopes.ADMIN_DIRECTORY_USER scope  
        user = directory.users().insert(user).execute();

        return user;
    }
}