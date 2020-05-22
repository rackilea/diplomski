import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("l11", "l12");
        List<String> l2 = Arrays.asList("l21");
        List<String> l3 = Arrays.asList("l31", "l32");
        List<List<String>> lists = Arrays.asList(l1, l2, l3);
        List<List<String>> allSubsets = allSubsets(lists);
        for (List<String> subset : allSubsets) {
            System.out.println(subset);
        }
    }

    static List<List<String>> allSubsets(List<List<String>> lists) {
        if (lists.isEmpty()) {
            List<String> empty = new ArrayList<>();
            return Arrays.asList(empty);
        }

        List<List<String>> reduced = new ArrayList<>();
        reduced.addAll(lists);
        List<String> list = reduced.remove(0);
        List<List<String>> subsets = allSubsets(reduced);
        List<List<String>> newSubsets = new ArrayList<>(subsets);
        for (List<String> subset : subsets) {
            for (String s : list) {
                List<String> newSubset = new ArrayList<>(subset);
                newSubset.add(s);
                newSubsets.add(newSubset);
            }
        }
        return newSubsets;
    }
}