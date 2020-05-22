import org.json.JSONArray;

public class GsonExample {

    public static void main(String[] args) {
        String jsonString="[{\"id\":[\"4\"]},{\"Flap\":[\"NA\"]}]";
        JSONArray arr= new JSONArray(jsonString);
        System.out.println(arr.getJSONObject(0).getJSONArray("id").get(0));
    }
}