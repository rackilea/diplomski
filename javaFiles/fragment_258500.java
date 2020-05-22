import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestEnum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, String> oldMap = new HashMap<String, String>();
        oldMap.put("akshay", "Lokur");
        oldMap.put("sumiT", "BORhade");

        Map<String, String> newMap = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        newMap.putAll(oldMap);
        String value = newMap.get("AKShay");
        System.out.println(value);
    }

}