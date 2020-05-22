import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(XModel.class, new XModelJsonDeserializer())
                .create();

        System.out.println(gson.fromJson(new FileReader(jsonFile), XModel.class));
    }
}

class XModelJsonDeserializer implements JsonDeserializer<XModel> {

    private final Set<String> TRUE_STRINGS = new HashSet<>(Arrays.asList("true", "1", "yes"));

    @Override
    public XModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        XModel response = new XModel();
        JsonObject jsonResponse = (JsonObject) json;
        response.setName(jsonResponse.get("name").getAsString());
        // other fields

        JsonElement dataElement = jsonResponse.get("isValid");
        if (dataElement.isJsonNull()) {
            response.setValid(false);
        } else if (dataElement.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = dataElement.getAsJsonPrimitive();
            if (jsonPrimitive.isBoolean()) {
                response.setValid(jsonPrimitive.getAsBoolean());
            } else if (jsonPrimitive.isNumber()) {
                response.setValid(jsonPrimitive.getAsNumber().intValue() == 1);
            } else if (jsonPrimitive.isString()) {
                response.setValid(TRUE_STRINGS.contains(jsonPrimitive.getAsString()));
            }
            System.out.println("Json data is primitive: " + dataElement.getAsString());
        } else if (dataElement.isJsonObject() || dataElement.isJsonArray()) {
            response.setValid(true); //?!?!
        }

        return response;
    }
}