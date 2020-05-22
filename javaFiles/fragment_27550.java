import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.lang.reflect.Field;

public class Main {
    public int a = 3;
    public String b = "Hello";

    public static void main(String[] args) {
        Map<String, Object> map = parameters(new Main());
        for (Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Object> parameters(Object obj) {
        Map<String, Object> map = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try { map.put(field.getName(), field.get(obj)); } catch (Exception e) { }
        }
        return map;
    }
}