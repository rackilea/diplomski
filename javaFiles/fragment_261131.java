import static java.util.Arrays.asList;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Integer a[] = new Integer[]{2, 4, 6, 8, 10};
        Integer b[] = new Integer[]{1, 3, 4, 5, 6};
        List<Integer> merged = CollectionUtils.collate(asList(a), asList(b));
    }
}