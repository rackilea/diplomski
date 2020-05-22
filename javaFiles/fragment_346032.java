import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ProgramsDeserializer implements JsonDeserializer<List<Program>> {
  @Override
  public List<Program> deserialize(JsonElement e, Type type, JsonDeserializationContext jdc) throws JsonParseException {
    List<Program> programs = new ArrayList<>(10);
    JsonObject root = e.getAsJsonObject();
    for (Map.Entry<String, JsonElement> entry : root.entrySet()) {
      String id = entry.getKey();
      String title = "";
      String description = "";
      JsonElement arrayElement = entry.getValue();
      if (arrayElement.isJsonArray()) {
        JsonArray array = arrayElement.getAsJsonArray();
        JsonElement objectElement = array.get(0);
        if (objectElement.isJsonObject()) {
          JsonObject object = objectElement.getAsJsonObject();
          title = object.get("t").getAsString();
          description = object.get("d").getAsString();
        }
      }
      programs.add(new Program(id, title, description));
    }
    return programs;
  }
}