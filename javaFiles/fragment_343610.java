import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class App
{

    public static void main( String[] args ) throws JSONException {
        JSONObject newObj = new JSONObject("{" +
                "\"data\": [\n" +
                "    {\n" +
                "\"id\": 1,\n" +
                "        \"userId\": 1,\n" +
                "        \"name\": \"ABC\",\n" +
                "        \"modified\": \"2014-12-04\",\n" +
                "        \"created\": \"2014-12-04\",\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"email\": \"abc@gmail.com\",\n" +
                "                \"links\": [\n" +
                "                    {\n" +

                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "        }\n" +
                "    ]\n" +
                "\n" +
                "}");



        JSONArray items = newObj.getJSONArray("data");
        for (int it = 0; it < items.length(); it++) {
            JSONObject contactItem = items.getJSONObject(it);
            String userName = contactItem.getString("name");


            JSONArray item = contactItem.getJSONArray("items");

            for (int i = 0; i < items.length(); i++) {
                String email = item.getJSONObject(i).getString("email");
                System.out.println(email);
            }

            System.out.println("Name----------" + userName);
        }
    }
}