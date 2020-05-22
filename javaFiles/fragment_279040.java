import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;

public class OrgJsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();
        String json = String.join("", Files.readAllLines(jsonFile.toPath()));

        JSONObject response = new JSONObject(json);
        response.keySet().forEach(key -> {
            JSONObject object = response.optJSONObject(key);
            // if given key represents object it must be data
            if (object != null) {
                final String dataKey = "data";
                JSONObject data = object.optJSONObject(dataKey);
                // extract mobile from data and remove data
                // this way JSON node is much simpler
                if (data != null) {
                    final String mobileKey = "mobile";
                    String mobile = data.optString(mobileKey);
                    System.out.println("Mobile => " + mobile);
                }
                System.out.println("status => " + object.optString("status"));
                System.out.println("message => " + object.optString("message"));
            }
        });
    }
}