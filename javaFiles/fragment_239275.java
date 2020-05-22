import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.JSONArray;      // JSON library from http://www.json.org/java/
import org.json.JSONObject;

public class GoogleQuery {

 // Put your website here
 private final String HTTP_REFERER = "http://www.example.com/";

 public GoogleQuery() {
  makeQuery("questio verum");
  makeQuery("info:http://frankmccown.blogspot.com/");
  makeQuery("site:frankmccown.blogspot.com");
 }

 private void makeQuery(String query) {

  System.out.println(" Querying for " + query);

  try
  {
   // Convert spaces to +, etc. to make a valid URL
   query = URLEncoder.encode(query, "UTF-8");

   URL url = new URL("http://ajax.googleapis.com/ajax/services/search/web?start=0&rsz=large&v=1.0&q=" + query);
   URLConnection connection = url.openConnection();
   connection.addRequestProperty("Referer", HTTP_REFERER);

   // Get the JSON response
   String line;
   StringBuilder builder = new StringBuilder();
   BufferedReader reader = new BufferedReader(
     new InputStreamReader(connection.getInputStream()));
   while((line = reader.readLine()) != null) {
    builder.append(line);
   }

   String response = builder.toString();
   JSONObject json = new JSONObject(response);

   System.out.println("Total results = " +
     json.getJSONObject("responseData")
     .getJSONObject("cursor")
     .getString("estimatedResultCount"));

   JSONArray ja = json.getJSONObject("responseData")
   .getJSONArray("results");

   System.out.println(" Results:");
   for (int i = 0; i < ja.length(); i++) {
    System.out.print((i+1) + ". ");
    JSONObject j = ja.getJSONObject(i);
    System.out.println(j.getString("titleNoFormatting"));
    System.out.println(j.getString("url"));
   }
  }
  catch (Exception e) {
   System.err.println("Something went wrong...");
   e.printStackTrace();
  }
 }

 public static void main(String args[]) {
  new GoogleQuery();
 }
}