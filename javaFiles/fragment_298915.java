import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class UpperCaseAdapter implements JsonSerializer<Map<String, Object>>, JsonDeserializer<Map<String, Object>> {
    public static final Type TYPE = new TypeToken<Map<String, Object>>() {}.getType();

    @Override
    public JsonElement serialize(Map<String, Object> src, Type typeOfSrc, JsonSerializationContext context) {
        // TODO implement serialization if needed
        return null;
    }

    @Override
    public Map<String, Object> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()) {
            Object value = null;
            if (entry.getValue().isJsonPrimitive()) {
                value = entry.getValue().getAsString();
            } else if (entry.getValue().isJsonObject()) {
                value = context.deserialize(entry.getValue(), TYPE); // deserialize the object using the same type
            } else if (entry.getValue().isJsonArray()) {
                // TODO implement deserailization of array
            } else if (entry.getValue().isJsonNull()) {
                // skip nulls
                continue;
            }
            map.put(entry.getKey().toUpperCase(), value); //toUpperCase() is what we want
        }
        return map;
    }
}