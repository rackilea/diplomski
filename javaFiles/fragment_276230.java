import java.util.*;

public class StringBatches {
    public static void main(String[] args) {
        String[] ss = {"A","B","B","A","K","B", "A"};

        List<Set<String>> l = new ArrayList<Set<String>>();
        for (String s : ss) {
            putInUniqueSet(l, 0, s);
        }
        System.out.println( l );
    }

    public static boolean putInUniqueSet( List<Set<String>> l, int idx, String s ) {
        if( l.size() <= idx )
            l.add(new HashSet<String>());
        return !l.get(idx).add(s) ? putInUniqueSet(l, idx+1, s) : true;
    }
}