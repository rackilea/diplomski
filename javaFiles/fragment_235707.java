import java.util.Random;
public class Solution {

    private static Random random = new Random();
    private static double[] arr = new double[6];

    private static double solve() {
        double sum;
        while (true) {
            sum = 0;
            for (int i = 0; i < 6; i++)
                sum += arr[i] = 3.5 + random.nextDouble() * (8 - 3.5);
            if (sum <= 36 && sum >= 30) break;
        }
                    // 2 decimal places
        for (int i = 0; i < 6; i++) {
            arr[i] = (int)(arr[i] * 100);
            arr[i] /= 100;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("The sum is " + solve() + "\nNumbers:");
        for (double i : arr)
            System.out.println(i);
    }
}