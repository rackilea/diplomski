import java.util.*;
import com.google.gson.Gson;

public class OrderedJson {
    public static void main(String[] args) {
        // Create a new ordered map.
        Map<String,String> myTreeHashMap = new TreeMap<String, String>();

        // Add items, in any order, to the map.
        myTreeHashMap.put("3", "third");
        myTreeHashMap.put("1", "first");
        myTreeHashMap.put("2", "second");

        // Instantiate a new Gson instance.
        Gson gson = new Gson();

        // Convert the ordered map into an ordered string.
        String json = gson.toJson(myTreeHashMap, TreeMap.class);

        // Print ordered string.
        System.out.println(json); // {"1":"first","2":"second","3":"third"}
    }
}