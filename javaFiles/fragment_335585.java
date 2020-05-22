import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetManifest {

    public static void main(String[] args) throws IOException, JSONException {
        try {
            String url = "https://www.aerosimulations.com/wp-content/uploads/example.json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();

            String line = "";
            while((line = in.readLine()) != null) {
                response.append(line).append(System.getProperty("line.separator"));
            }

            JSONObject responseJSON = new JSONObject(response.toString());
            JSONObject obj1_JSON = responseJSON.getJSONObject("patches");

            System.out.println(obj1_JSON);

            JSONArray patches = obj1_JSON.names();

            System.out.println(patches);


        } catch (MalformedURLException e) {

        }

    }

}