import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<List<Integer>> y = new ArrayList<List<Integer>>();
        y.add(new ArrayList<Integer>(Arrays.asList(1)));
        y.add(new ArrayList<Integer>(Arrays.asList(4)));
        y.add(new ArrayList<Integer>(Arrays.asList(5, 6, 9)));
        y.add(new ArrayList<Integer>(Arrays.asList(45)));
        y.add(new ArrayList<Integer>(Arrays.asList(67)));
        Collections.shuffle(y);
        List<Integer> flatList = new ArrayList<>();
        y.forEach(flatList::addAll);

    }

}