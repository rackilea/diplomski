import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        //Delaring Variables

        int iterations, length, midDummy, midDummy2, count;//EDIT: removed some unused variables here
        float mid, p, q;
        length = expenditure.length;
        iterations = length - d;
        count = 0;

        //EDIT: add the first d values to the sub-array and sort it (only once)
        int[] exSub = new int[d];
        System.arraycopy(expenditure, 0, exSub, 0, d);
        Arrays.sort(exSub);

        for (int iter = 0; iter < iterations; iter++) {
            //EDIT: don't sort the complete array in every iteration
            //instead remove the one value (the first day that is not used anymore) and add the new value (of the new day) into the sorted array
            //sorting is done in O(n * log(n)); deleting and inserting a new value into a sorted array is done in O(log(n))

            if (iter > 0) {//not for the first iteration
                int remove = expenditure[iter - 1];
                int indexToRemove = find(exSub, remove);
                //remove the index and move the following values one index to the left
                exSub[indexToRemove] = 0;//not needed; just to make it more clear what's happening
                System.arraycopy(exSub, indexToRemove + 1, exSub, indexToRemove, exSub.length - indexToRemove - 1);
                exSub[d - 1] = 0;//not needed again; just to make it more clear what's happening

                int newValue = expenditure[iter + d - 1];
                //insert the new value to the correct position
                insertIntoSortedArray(exSub, newValue);
            }

            //For each iteration claculate the median
            if (d % 2 == 0) // even
            {
                midDummy = d / 2;
                p = exSub[midDummy];
                q = exSub[midDummy - 1];
                mid = (p + q) / 2;
                //mid = (exSub[midDummy]+exSub                                   [midDummy-1])/2;
                //System.out.println(midDummy);
            }
            else // odd
            {

                midDummy2 = d / 2;
                mid = exSub[midDummy2];
                //System.out.println(midDummy2);
            }

            if (expenditure[iter + d] >= 2 * mid) {
                count++;
            }
        }

        System.out.println("Count:" + count);
        return count;

    }

    /**
     * Find the position of value in expenditure
     */
    private static int find(int[] array, int value) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                index = i;
            }
        }

        return index;
    }

    /**
     * Find the correct position to insert value into the array by bisection search
     */
    private static void insertIntoSortedArray(int[] array, int value) {
        int[] indexRange = new int[] {0, array.length - 1};
        while (indexRange[1] - indexRange[0] > 0) {
            int mid = indexRange[0] + (indexRange[1] - indexRange[0]) / 2;
            if (value > array[mid]) {
                if (mid == indexRange[0]) {
                    indexRange[0] = mid + 1;
                }
                else {
                    indexRange[0] = mid;
                }
            }
            else {
                if (mid == indexRange[1]) {
                    indexRange[1] = mid - 1;
                }
                else {
                    indexRange[1] = mid;
                }
            }
        }

        System.arraycopy(array, indexRange[0], array, indexRange[0] + 1, array.length - indexRange[0] - 1);
        array[indexRange[0]] = value;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        //Just for testing; can be deleted if you don't need it
        /*int[] exp = new int[] {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int d = 5;
        activityNotifications(exp, d);

        int[] exp2 = new int[] {1, 2, 3, 4, 4};
        d = 4;
        activityNotifications(exp2, d);*/
    }
}