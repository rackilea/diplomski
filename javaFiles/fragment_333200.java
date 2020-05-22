import java.util.*;
import java.lang.*;

public class StringListMapExample {

    public static String asTreeFormattedString(HashMap<String,List<String>> map) {
        final StringBuilder builder = new StringBuilder();
        for (String key : map.keySet()) {
            builder.append(key + "\n");
            for (String string : map.get(key)) {
                builder.append("\t" + string + "\n");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("order", Arrays.asList(new String[]{"page1", "page2", "page3"}));
        System.out.println(asTreeFormattedString(map));
    }
}