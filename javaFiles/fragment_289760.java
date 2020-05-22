package stackoverflow;

public class MinimumSubArray {

    public static void main(String[] args) {
        solve(5, 2, new int[]{ 10, 0, 3, 2, 5 }); // expect 0 0 2 2
        solve(5, 2, new int[]{ 10, 0, 3, 2, 1 }); // expect 0 0 2 1
        solve(1, 1, new int[]{ 6 }); // expect 6
        solve(3, 3, new int[]{ 3, 2, 1 }); // expect 1
        solve(3, 1, new int[]{ 3, 2, 1 }); // expect 3 2 1
    }

    private static void solve(final int n, final int k, final int[] array) {
        if (n != array.length)
            throw new IllegalArgumentException( String.format("Array length must be %d.", n) );

        if (k > n)
            throw new IllegalArgumentException( String.format("K = %d is bigger than n = %d.", k, n) );

        int currentStartIndex = 0;

        while (currentStartIndex <= (n - k)) {
            int min = array[currentStartIndex];

            for (int i = currentStartIndex + 1; i < currentStartIndex + k; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }

            System.out.printf("%d ", min); // print minimum of the current sub-array

            currentStartIndex++;
        }

        System.out.println();
    }
}