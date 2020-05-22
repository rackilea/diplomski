import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HangsMan {

    public static void main(String[] args) {
        String[] words = new String[]{"fish", "look", "flow", "fowl", "cool", "eel", "poll", "fill"};
        char letter = 'l';
        Map<Integer, List<String>> theMap = new HashMap<>();
        Integer key;
        List<String> value;
        for (String word : words) {
            int ndx = word.indexOf(letter);
            int last = word.lastIndexOf(letter);
            if (last == ndx + 1) {
                ndx += 1_000_000;
            }
            key = Integer.valueOf(ndx);
            if (theMap.containsKey(key)) {
                value = theMap.get(key);
            }
            else {
                value = new ArrayList<String>();
                theMap.put(key, value);
            }
            value.add(word);
        }
        theMap.forEach((k, v) -> System.out.println(v));
    }
}