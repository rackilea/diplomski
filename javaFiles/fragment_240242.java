import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Example {

public static void main(String[] args) {
    String jsonString = "{\"head\":[\"head1\",\"head2\",\"head3\"],\"tail\": [[\"tail1\",\"tail2\",\"tail3\"],[\"tail1a\",\"tail2a\",\"tail3a\"]]}";
    try {
        JSONObject mainJsonObject = new JSONObject(jsonString);
        JSONArray headJsonArray = mainJsonObject.getJSONArray("head");
        JSONArray tailJsonArray = mainJsonObject.getJSONArray("tail");
        Map<String, List<String>> keyValue = new HashMap<String, List<String>>();
        int index = 0;
        for (int i = 0; i < headJsonArray.length(); i++) {
            String head = headJsonArray.getString(i);
            List<String> values = new ArrayList<String>();
            for (int j = 0; j < tailJsonArray.length(); j++) {
                JSONArray anotherTailArray = tailJsonArray.getJSONArray(j);
                values.add(anotherTailArray.getString(index));
            }
            keyValue.put(head, values);
            index++;
        }

        for (String key: keyValue.keySet()) {
            List<String> values = keyValue.get(key);
            for (int i = 0; i < values.size(); i++) {
                System.out.println(key + " = " + values.get(i));
            }
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }

}
}