import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
public class Client {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            getJsonHttp();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void getJsonHttp() throws IOException, JSONException {
            JSONParser jsp = new JSONParser();
            String url ="http://api.wunderground.com/api/<key>/conditions/q/Australia/Brisbane.json";
                JSONObject obj = jsp.makeHttpRequest(url, "GET");
                JSONObject disp = obj.getJSONObject("current_observation");
               JSONObject des = disp.getJSONObject("display_location");
               JSONObject jObject = new JSONObject(des.toString().trim());
               Iterator<?> keys = jObject.keys();
               while( keys.hasNext() ) {
                   String key = (String)keys.next();
                      if("full".equals(key) || "city".equals(key) || "state".equals(key) || "state_name".equals(key)){
                          System.out.println(jObject.get(key).toString());
                      }
               }   
    }
}