import java.net.URL;
import java.net.HttpURLConnection;
import java.io.ObjectInputStream;

/**
 * This is a simple example to read an object. 
 *
 * This is not production ready code ;-)
 */
public class Sample {

    public static void main(final String [] pArgs) throws Exception {

        // Change SERVER:PORT/PATH to match your application.
        final URL url = new URL("http://SERVER:PORT/PATH");
        final HttpURLConnection conn = (HttpURLConnection)url.openConnection();

        conn.setRequestMethod("GET");
        conn.setReadTimeout(10000);
        conn.connect();

        final ObjectInputStream is 
        = new ObjectInputStream(conn.getInputStream());

        final Object obj = is.readObject();

        if (obj instanceof String) System.out.println((String)obj);
        else // Convert to object and do whatever.

        is.close();
        conn.disconnect();
    }
}