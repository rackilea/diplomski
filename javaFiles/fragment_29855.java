import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GsonApp {
    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("nullKey", null);
        map.put("other", "Not Null!");

        Foo foo = new Foo();
        foo.setMyMap(map);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapterFactory(new ForceNullsForMapTypeAdapterFactory())
                .create();
        System.out.println(gson.toJson(foo));
    }
}