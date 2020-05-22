package so53375733;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("netflix", "dhoni", "harini", "obama", "machintosh");
        List<String> list2 = Arrays.asList("netflix", "dhoni", "harini", "obama", "quark", "machintosh");
        int addedElementIndex = findAddedElement(list1, list2);
        System.out.printf(
                "Found difference at index %1$d:%n" +
                        "list1[%1$d] = \"%2$s\"%n" +
                        "list2[%1$d] = \"%3$s\"%n",
                addedElementIndex,
                addedElementIndex < list1.size() ? list1.get(addedElementIndex) : "[end of list]",
                addedElementIndex < list2.size() ? list2.get(addedElementIndex) : "[end of list]");
    }

    /**
     * Performs a binary search for an added (or removed) element of list1 with respect to list2
     * (or vice versa). The lists passed as argument should differ only by the addition of one element,
     * so that their sizes differ by 1 and the lists are identical except for the extra element in one
     * of the lists. If the lists are random-access (i.e. directly indexable in O(1) time) then this
     * method's time complexity is O(log N).
     * @param list1 A random-access list
     * @param list2 A random-access list
     * @return The index of the extra element
     */
    private static <T> int findAddedElement(List<T> list1, List<T> list2) {
        int low = 0;
        int high = Math.min(list1.size(), list2.size()) - 1;

        if (list1.get(high).equals(list2.get(high)))
            return high + 1;

        // Loop invariants:
        // 1. Elements of list1 are equal to those of list2 at all indices less than 'low'.
        // 2. Elements of list1 are NOT equal to those of list2 at all indices >= 'high'.
        while (low < high) {
            int mid = (low + high) >>> 1;  // (low+high)/2 might overflow
            if (list1.get(mid).equals(list2.get(mid)))
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}