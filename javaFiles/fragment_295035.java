import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    static boolean match = true;

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        List<String> list = Arrays.asList("Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7");
        map.put("Test1", 1);
        map.put("Test66", 2);
        map.put("Test3", 3);
        map.put("Test4", 4);
        map.put("Test123", 5);


        map.forEach((k, v) -> {
            match = false;
            list.forEach(s -> {
                if (k.equals(s))
                    match = true;
            });
            if(match)
                map1.put(k,v);
        });
        map = map1;
        map.forEach((k,v)->System.out.println(k));
    }
}