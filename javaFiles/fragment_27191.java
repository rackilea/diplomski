import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> hm = new HashMap<>();
        hm.put("john smith", "mr");
        hm.put("kim taylor", "prof");
        hm.put("shannon sperling", "miss");
        List<String> list = new ArrayList<String>();
        for (String key : hm.keySet())
            list.add(hm.get(key) + " | " + key);
        for (String s:list)
            System.out.println(s);
    }

}