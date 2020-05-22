import java.util.*;

public class Test {

    public static void main(String[] args) {
        Map<String, String> map = getMap();
        map.put("a", "b");
    }

    public static final Map<String, String> getMap(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("x", "y");
        return Collections.unmodifiableMap(map);
    }
}