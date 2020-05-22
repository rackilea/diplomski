import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
public class Test {
    public static void main(String[] args) {
        String in = "{\"hello\":\"world\"}";
        System.out.println(in);
        JsonElement root = new JsonParser().parse(in);
        System.out.println(root.getAsJsonObject().get("hello").toString());
        System.out.println(root.getAsJsonObject().get("hello").getAsString());
    }
}