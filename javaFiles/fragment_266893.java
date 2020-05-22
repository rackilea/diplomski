import android.os.AsyncTask;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;

public class DownloadContent extends AsyncTask<String, Void, String> {
private final Callback callback;
private final String username, password;

private DownloadContent(@NonNull String username, @NonNull String password, @NonNull Callback callback) {
    this.callback = callback;
    this.username = username;
    this.password = password;
}

public static void run(@NonNull String username, @NonNull String password, @NonNull Callback callback) {
    DownloadContent loader = new DownloadContent(username, password, callback);
    // runs doInBackground asynchronous
    loader.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
}

@Override
protected String doInBackground(String... strings) {
    try {
        String credentials = username + ":" + password;
        URL url = new URL ("https://vertretungsplanbbscux.000webhostapp.com/auth/index.html");
        // encode to 64 encoded string (necessary for authorization header)
        String base64 = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        // perform a post request
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        // append encoded username and password as authorization header
        connection.setRequestProperty  ("Authorization", "Basic " + base64);
        InputStream stream = connection.getInputStream();
        BufferedReader reader = new BufferedReader (new InputStreamReader(stream));
        String inputLine;
        StringBuilder response = new StringBuilder();
        // read html of website
        while ((inputLine = reader.readLine()) != null)
            response.append(inputLine);
        reader.close();
        return response.toString();
    } catch(Exception e) {
        e.printStackTrace();
    }
    // return null if an error has occurred
    return null;
}

@Override
protected void onPostExecute(@Nullable String content) {
    // called after doInBackground has finished, synchronous again
    if (content == null) {
        callback.onNotLoaded();
    } else {
        callback.onLoaded(content);
    }
}

public interface Callback {
    void onLoaded(String content);
    void onNotLoaded();
}
}