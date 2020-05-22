import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<Integer>();
        List<Integer> toAdd = new ArrayList<Integer>();
        int stepSize = 10;

        al.add(20);
        al.add(30);
        al.add(40);

        Iterator<Integer> it = al.iterator();
        while (it.hasNext()) {
            int value = it.next();
            if (value == al.get(al.size() - 1)){
                toAdd.add(value + stepSize);
            }
        }

        // Add all elements
        al.addAll(toAdd);

        // Print
        al.forEach(System.out::println);
    }
}