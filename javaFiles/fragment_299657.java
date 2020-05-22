import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// ...
    try {
        URL url = new URL("http://www.example.com/atom.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            // ...
        }
        reader.close();

    } catch (MalformedURLException e) {
        // ...
    } catch (IOException e) {
        // ...
    }