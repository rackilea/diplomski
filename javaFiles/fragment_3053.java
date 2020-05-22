import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) {
        JsonObject json1 = (JsonObject) new JsonParser().parse("{\"message\":\"test\",\"status\":\"0\"}");
        JsonObject json2 = (JsonObject) new JsonParser().parse("{\"message\":\"test-2\",\"status\":\"1\"}");
        JsonArray array = new JsonArray();
        array.add(json1);
        array.add(json2);
        System.out.println(array.toString());
    }
}