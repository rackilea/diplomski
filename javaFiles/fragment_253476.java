import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    static final Comparator<String> aStringComparator = new Comparator<String>() {
        public int compare(String s1, String s2) {
            //assumed input are strings in the form axxxx
            int numfromS1 = Integer.valueOf(s1.subSequence(1, s1.length()).toString());
            int numfromS2 = Integer.valueOf(s2.subSequence(1, s2.length()).toString());
            return numfromS1 - numfromS2;
        }
    };

    public static void main(String[] args) {
        List<String> child = Arrays.asList("a5", "a10", "a2", "a1", "a40");
        Collections.sort(child, aStringComparator);
        System.out.println(child);
    }
}