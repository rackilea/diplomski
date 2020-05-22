import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {
    String fruits[] = new String[7];
    List<String> lst;

    Sorter() {
        lst = new ArrayList<String>();
        // initialise UNSORTED array
        fruits[0] = "Melon"; fruits[1] = "apricot"; fruits[2] = "peach";
        fruits[3] = "mango"; fruits[4] = "Apple";   fruits[5] = "pineapple";
        fruits[6] = "banana";
    }

    public static void main(String[] args) {
        Sorter srt = new Sorter();
        srt.anyOldUnstaticMethod();

    }
    public void anyOldUnstaticMethod() {
        Collections.addAll(lst, fruits);
        System.out.println("Initial List");
        for (String s : lst)
            System.out.println(s);
        Collections.sort(lst);
        System.out.println("\nSorted List");
        for (String s : lst)
            System.out.println(s);
        Collections.sort(lst, new SortIgnoreCase());
        System.out.println("\nSorted Ignoring Case List");
        for (String s : lst)
            System.out.println(s);
    }

    public class SortIgnoreCase implements Comparator<Object> {
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
    }
}