import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

...

String jsonStr = "[{\n" +
  "    \"name\": \"ABC\",\n" +
  "    \"sub\": \"maths\"\n" +
  "}, {\n" +
  "    \"name\": \"DCF\",\n" +
  "    \"sub\": \"SCI\"\n" +
  "}]";

JsonParser parser = new JsonParser();
JsonElement jsonElement = parser.parse(jsonStr);
JsonArray json = jsonElement.getAsJsonArray();

json.get(0).getAsJsonObject().get("name").getAsString(); //will return abc