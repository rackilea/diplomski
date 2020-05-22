import java.util.ArrayList;
import java.util.List;

public class Test {

public static void main(String[] args) {
    String key = args[0];
    String value = args[1];
    List<List<String>> results = test(key, value);
    System.out.println(results);
}

private static List<List<String>> test(String key, String Value) {
    List<List<String>> keylist = new ArrayList<List<String>>();
    for (int i = 0; i < 10; i++) {
        List<String> valuelist = new ArrayList<String>();
        valuelist.add(i + key);
        valuelist.add(i + Value);
        keylist.add(valuelist);
    }
    System.out.println(keylist.get(1).get(1));
    return keylist;
}

}