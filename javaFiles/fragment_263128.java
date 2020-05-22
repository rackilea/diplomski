import org.json.*;

public class Test {
    public static void main(String[] args) {
        String json = "[[\"1\",\"100\"],[\"2\",\"200\"],[\"3\",\"300\"]]";
        JSONArray array = new JSONArray(json);
        JSONArray first = array.getJSONArray(0);
        System.out.println(first.getString(1)); // Prints 100
    }
}