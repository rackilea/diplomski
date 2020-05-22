import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;

public class NasaRestAPIExample {

    public static void main(String[] args) throws IOException {
        String query = "lon=100.75&lat=1.5&begin=2014-02-01&api_key=DEMO_KEY";

        URLConnection connection = new URL("https://api.nasa.gov/planetary/earth/assets?" + query).openConnection();
        connection.connect();

        BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb.toString());
    }
}