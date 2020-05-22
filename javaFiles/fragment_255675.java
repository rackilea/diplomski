import java.util.ArrayList;

public class PrimeGenerator {
    public static void main(String[] args) {
        int max = 100;

        System.out.println("Generate Prime numbers between 1 and 100. \"1\" is not prime.");

        ArrayList<Integer> list = new ArrayList<Integer>();

        // loop through the numbers one by one
        for (int n = 1; n < max; n++) {
            boolean prime = true;
            // analyzes if n is prime

            for (int j = 2; j < n; j++) {
                if (n % j == 0) {
                    prime = false;
                    break; // exit the inner for loop
                    }
            }
            if (prime && n != 1) {
                list.add(n);
            }
        }
        for (int i : list) {
            System.out.println(i + " ");
        }
    }
}