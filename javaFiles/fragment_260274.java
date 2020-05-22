import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class TestUnmod {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");

        Map<String,String> unmod = Collections.unmodifiableMap(map);
        Iterator<String> it = unmod.values().iterator();
        System.out.println(it.next());
        map.put("d", "d");
        System.out.println(it.next());
    }
}