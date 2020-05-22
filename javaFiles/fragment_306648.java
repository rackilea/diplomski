import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("foo1", "a");
        map.put("foo2", "b");
        map.put("bar1", "c");
        map.put("bar2", "d");
        map.put("foo3", "e");
        System.out.println("Before: " + map);

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().startsWith("foo")) {
                iterator.remove();
            }
        }
        System.out.println("After: " + map);
    }
}