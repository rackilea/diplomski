import java.util.*;
import com.google.gson.Gson;

public class OrderedJson {
    public static void main(String[] args) {
        // Create a new ordered map.
        Map<String,String> myLinkedHashMap = new LinkedHashMap<String, String>();

        // Add items, in-order, to the map.
        myLinkedHashMap.put("1", "first");
        myLinkedHashMap.put("2", "second");
        myLinkedHashMap.put("3", "third");

        // Instantiate a new Gson instance.
        Gson gson = new Gson();

        // Convert the ordered map into an ordered string.
        String json = gson.toJson(myLinkedHashMap, LinkedHashMap.class);

        // Print ordered string.
        System.out.println(json); // {"1":"first","2":"second","3":"third"}
    }
}