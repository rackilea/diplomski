import java.util.HashMap;

public class MapPutExample {

    public final static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("String1", "123");
        map.put("String2", "456");
        System.out.println(map.get("String1")); //would print 456
    }
}