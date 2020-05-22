import java.util.*;

public class Foo {
    public static void main(String[] args) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        List<String> l = new LinkedList<String>();
        l.add("col_value_1");
        l.add("col_value_2");
        //and so on
        m.put("col_name_1",l); //repeat for the rest of the colnames

       //then, to get it you do

       List<String> rl = m.get("col_name_1");

    }
}