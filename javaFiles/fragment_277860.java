import java.util.*;

public class Test {

    private static String[] val1 = {
            "q", "w", "e", "r", "t", "y"
    };

    private static String[] val2 = {
            "u", "i", "o", "p", "[", "]"
    };

    public static void main(String[] args) {
        Vector<String> keyVector = new Vector<String>();
        Vector<Vector<String>> valueVector = new Vector<Vector<String>>();

        keyVector.add("foo");
        keyVector.add("bar");

        valueVector.add(new Vector<String>(Arrays.asList(val1)));
        valueVector.add(new Vector<String>(Arrays.asList(val2)));

        //now let's say you want to find the objects that correspond with the key "bar"
         String key = "bar";

        for (int i = 0; i < keyVector.size(); i++) {
            if (keyVector.get(i).equals(key)) {
                System.out.println(valueVector.get(i));
            }
        }
     }
 }