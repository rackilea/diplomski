import java.util.Arrays;

public class RowBreakerRunner {
    public static void main(String[] args) {

        int[] one = { 36, 271, 343, 2001, 1048 };
        RowBreaker rb1 = new RowBreaker(one);
        int[] sums1 = rb1.getSums();

        int[] two = { 361, 2348, 174, 129, 7002 };
        RowBreaker rb2 = new RowBreaker(two);
        int[] sums2 = rb2.getSums();

        Arrays.stream(sums1).forEach(n -> System.out.println(n));
        Arrays.stream(sums2).forEach(n -> System.out.println(n));

    }
}

public class RowBreaker {

    private int[] arr;

    public RowBreaker(int[] GO) {
        arr = GO;
    }

    public int[] getSums() {
        int theSum = 0;
        int[] sum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            while (n != 0) {
                if (n % 10 != 0) {
                    sum[i] = theSum;
                }
            }
            n = n / 10;
        }
        return sum;
    }
}