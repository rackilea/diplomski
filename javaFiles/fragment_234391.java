import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class GsonApp {

    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<>();
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();

        String jsonString = "{\"No\":0,\"Cast\":2}";

        Type mapType = new TypeToken<Map<String, String>>() {}.getType();
        map.put("Intro", gson.fromJson(jsonString, mapType));
        map.put("Output", "123");
        System.out.println(gson.toJson(map));
    }
}