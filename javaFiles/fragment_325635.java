import com.google.gson.JsonParser;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
//...

Gson gson = new GsonBuilder().create();
JsonParser parser = new JsonParser();
JsonElement jsonElement = parser.parse(json);
ErrorResponse response = gson.fromJson(jsonElement.getAsJsonObject().get("response"), ErrorResponse.class);