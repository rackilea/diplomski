import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("food");
        set.add("bad");
        set.add("hungry");
        set.add("neighbour");

        Iterator<String> it = set.iterator();

        // Remove any string longer than 4
        while (it.hasNext())
        {
            if (it.next().length() > 4)
            {
                it.remove();
            }
        }

        set.add("new long text");
        set.add("x");

        // Remove any string shorter than 4
        it = set.iterator();

        while (it.hasNext())
        {
            if (it.next().length() < 4)
            {
                it.remove();
            }
        }

        // Dump the results
        for (String x : set)
        {
            System.out.println(x);
        }
    }
}