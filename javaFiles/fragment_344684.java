package gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import com.example.Example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonMain {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        byte[] jsonBytes = Files.readAllBytes(Paths.get("./src/main/java/gson/jsonData.json"));
        String json = new String(jsonBytes);

        Map<String,Example> result = gson.fromJson(json, new TypeToken<Map<String, Example>>(){}.getType());

        System.out.println("RESULTS: "+result);
    }

}