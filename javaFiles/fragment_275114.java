import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRedirectURL {
    public static void main(final String... args) throws IOException {
        final URL url = new URL("http://www.google.com/");
        //HttpURLConnection.setFollowRedirects(false);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //con.setInstanceFollowRedirects(false);
        final int responseCode = con.getResponseCode();
        final String location = con.getHeaderField("Location");
        System.err.format("%d%n%s%n", responseCode, location);
    }
}