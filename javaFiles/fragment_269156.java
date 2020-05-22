import java.util.Arrays;

public class __QuickTester {

    public static void main(String[] args) {

        // This didn't work with original code
        int[] toBeSorted = new int[]{5, 9, 3, 4, 6, 7, 1, 8, 2};

        System.out.println(Arrays.toString(quicksort(toBeSorted)));

        toBeSorted = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(quicksort(toBeSorted)));

        toBeSorted = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(quicksort(toBeSorted)));

        toBeSorted = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5, 777, 999, 888};

        System.out.println(Arrays.toString(quicksort(toBeSorted)));
    }

    // accesses quicksort
    public static int[] quicksort(int[] toBeSorted) {
        int[] sorted = qSort(toBeSorted, 0, toBeSorted.length);
        return sorted;
    }

    // performs quicksort algorithm recursively
    public static int[] qSort(int[] toBeSorted, int left, int right) {

        int i, lastsmall, holdThis;
        if (left < right) {
            lastsmall = left;
            for (i = left; i < right; i++) {
                if (toBeSorted[i] < toBeSorted[left]) {
                    lastsmall = lastsmall + 1;
                    holdThis = toBeSorted[i];
                    toBeSorted[i] = toBeSorted[lastsmall];
                    toBeSorted[lastsmall] = holdThis;
                }
            }

            holdThis = toBeSorted[left];
            toBeSorted[left] = toBeSorted[lastsmall];
            toBeSorted[lastsmall] = holdThis;

            qSort(toBeSorted, left, lastsmall);
            qSort(toBeSorted, lastsmall + 1, right);
        }

        return toBeSorted;
    }
}