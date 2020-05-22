import java.util.Set;
import java.util.HashSet;

public class Equaller {

    public static boolean checkEqual(Integer[][] array) {
        if (array.length > 0) {
            Set<Integer> firstSet = new HashSet<Integer>(array[0].length);
            // fill first set
            for (Integer i : array[0]) {
                firstSet.add(i);
            }
            // compare 2D array with first set
            for (Integer[] intArray : array) {
                Set<Integer> secondSet = new HashSet<Integer>(firstSet.size());
                for (Integer i : intArray) {
                    if (!firstSet.contains(i)) {
                        return false;
                    }
                    secondSet.add(i);
                }
                if (firstSet.size() != secondSet.size()) {
                    return false;
                }
            }
        }
        return true;
    }
}