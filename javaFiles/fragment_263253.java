import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        //Delaring Variables

        int iterations, itr, length, median, midDummy, midL, midR, midDummy2, i, i1, temp, count;
        float mid, p, q;
        length = expenditure.length;
        iterations = length - d;
        i = 0;
        i1 = 0;
        itr = 0;
        count = 0;

        int[] exSub = new int[d];

        //EDIT: replace while loops with for loops if possible
        //while (iterations > 0) { 
        for (int iter = 0; iter < iterations; iter++) {

            //EDIT: here you can again use a for loop or just use System.arraycopy which should be (slightly) fasters
            // Enter the elements in the subarray
            /*while (i1 < d) {
                exSub[i1] = expenditure[i + i1];
                //System.out.println(exSub[i1]);
                i1++;
            }*/
            System.arraycopy(expenditure, i, exSub, 0, d);

            //EDIT: Don't use bubble sort!!! It's one of the worst sorting algorithms, because it's really slow
            //Bubble sort uses time complexity O(n^2); others (like merge-sort or quick-sort) only use O(n*log(n))
            //The easiest and fastest solution is: don't implement sorting by yourself, but use Arrays.sort(int[]) from the java API

            //Sort the exSub array
            /*for (int k = 0; k < (d - 1); k++) {
                for (int j = k + 1; j < d; j++) {
                    if (exSub[j] < exSub[k]) {
                        temp = exSub[j];
                        exSub[j] = exSub[k];
                        exSub[k] = temp;
                    }
                }
            }*/
            Arrays.sort(exSub);


            //Printing the exSub array in each iteration

            //EDIT: printing many results also takes much time, so only print the results if it's really needed

            /*for (int l = 0; l < d; l++) {
                System.out.println(exSub[l]);
            }*/

            i1 = 0;

            //For each iteration claculate the median

            if (d % 2 == 0) // even
            {
                midDummy = d / 2;
                p = (float) exSub[midDummy];
                q = (float) exSub[midDummy - 1];
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

            if (expenditure[itr + d] >= 2 * mid) {
                count++;
            }
            itr++;
            i++;
            //iterations--;//EDIT: don't change iterations anymore because of the for loop

            System.out.println("Mid:" + mid);
            System.out.println("---------");

        }

        System.out.println("Count:" + count);
        return count;

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
    }
}