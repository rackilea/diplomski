import org.json.*;

....

public boolean isJSONArray(String input) {
    try {
        new JSONArray(input);
        return true;
    } catch (JSONException ex) {
        return false;
    }
}