import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> list1 = new ArrayList<Integer>();
    private static List<Integer> list2 = new ArrayList<Integer>();

    public static void main(String[] args) {
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(10);
        list2.add(11);
        list2.add(12);
        Collection<Integer> result = Operations.add(list1, list2);
        System.out.println(result);
    }
}