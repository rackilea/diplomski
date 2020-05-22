import java.util.TreeSet;
import java.util.Comparator;
import java.util.Arrays;

public class MyComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length == s2Length) {
             return s1.compareTo(s2);
        }
        else {
              return s1Length - s2Length;
        }


    }

    public static void main(String[] args) {
    String[] strings = {"Hello", "Hello", "longer", "1", "477727357235", "hello"};



    TreeSet<String> set = new TreeSet<String>(new MyComparator());
        set.addAll(Arrays.asList(strings));

        // Won't be duplicates with substrings
        String s = "Hello World";
        set.add(s);
        for (int i = 0; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            set.add(s1);
        }
        // Still won't be a duplicate, even if we make a copy of the string.
        set.add(new String(s));

        System.out.println(set);
}
}