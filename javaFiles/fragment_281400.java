import java.util.*;

public class Sandbox {
    public static void main(String[] args) {
        final ArrayList<Integer> list = new ArrayList<Integer>(5);
        Collections.addAll(list, 1, 2, 3, 4, 5);
        printAll(list);
    }

    private static void printAll(Collection<Integer> collection) {
        for (Integer num : collection)
            System.out.println(num);
    }
}