import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

    // ...
    String message = URLEncoder.encode("my message", "UTF-8");

    try {
        URL url = new URL("http://www.example.com/comment");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write("message=" + message);
        writer.close();

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            // OK
        } else {
            // Server returned HTTP error code.
        }
    } catch (MalformedURLException e) {
        // ...
    } catch (IOException e) {
        // ...
    }