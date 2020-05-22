import java.util.Hashtable;

public class StrMap {
    public static void main(String[] args) {
        Hashtable<String,Object> map = new Hashtable<String,Object>();
        map.put("ABCD", "value");
        System.err.println(map.containsKey("ABCD"));
    }
}