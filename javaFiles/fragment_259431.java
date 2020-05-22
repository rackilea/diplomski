import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws JSONException, IOException {
        // TODO: replace me
        String devId = "XXX";
        JSONObject query = new JSONObject("{'userId': 'stavgallery'}");
        JSONObject jsonObj = new JSONObject("{'getBoothRequest':" + query +"}");
        URL url = new URL("http://api.bonanza.com/api_requests/standard_request");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("X-BONANZLE-API-DEV-NAME", devId);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(jsonObj.toString());
        writer.flush();
        writer.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        JSONObject sampleReturn = new JSONObject(in.readLine());
        System.out.println(sampleReturn);
    }
}