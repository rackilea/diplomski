import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CustomSerializer implements JsonSerializer<BaseDesign> {
@Override
public JsonElement serialize(BaseDesign src, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject object = new JsonObject();
    object.addProperty("id", src.getId());
    object.addProperty("name", src.getName());
    List<Cost> listOfCost = src.getCosts();
    if (listOfCost != null && listOfCost.size() != 0) {
        object.addProperty("cost", listOfCost.get(0).getValue());
        object.remove("costs");
    }
    return object;
  }

}