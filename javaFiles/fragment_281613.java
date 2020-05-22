import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Scratch {
    public static void main(String[] args) throws Exception {
        String json = "{ \"labels\": { \"kubernetes.io/hostname\": \"192.168.200.176\", \"node\": \"master\" } }";
        Map<String, String> library = new HashMap<>();

        // parse the input string
        JSONObject labels = new JSONObject(json).getJSONObject("labels");

        // iterate over keys and insert into Map
        for (String key : labels.keySet()) {
            library.put(key, labels.getString(key));
        }

        System.out.println(library);
        // {kubernetes.io/hostname=192.168.200.176, node=master}
    }
}