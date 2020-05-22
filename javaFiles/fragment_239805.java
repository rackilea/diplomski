import org.json.JSONObject;
import org.json.JSONException;

public class Test {
    public static void main(String[] args) {
        try {
            String platformJsonContent = "{\"scout\": \"webdriver\", \"short_version\": \"4.3\", \"long_name\": \"iPad\", \"api_name\": \"ipad\", \"long_version\": \"4.3.\", \"automation_backend\": \"webdriver\", \"os\": \"Mac 10.6\"}";

            JSONObject platforms = new JSONObject(platformJsonContent);

            System.out.println(platforms.get("os"));
        } catch(JSONException ex) {
            // do something...
        }
    }
}