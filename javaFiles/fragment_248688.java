import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class StackOverflowTest {

    public static void saveImage(final String imageUrl, final String destinationFile) throws IOException {
        final URL url = new URL(imageUrl);
        final HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();

        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        urlConnection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        urlConnection.setInstanceFollowRedirects(true);

        final InputStream is = urlConnection.getInputStream();
        final OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }

    public static void main(final String args[]) throws Exception {

        final String imageUrl = "https://familysearch.org/pal:/MM9.3.1/TH-1971-28699-12927-58.jpg";
        final String destinationFile = "./image.jpg";

        saveImage(imageUrl, destinationFile);
    }
}