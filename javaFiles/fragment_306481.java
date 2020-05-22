public class Fibonacci {

    private static final int LIMIT = 10;

    private static int fibonacci(int n) {
        if (n == 1) {
            // The 1st Fibonacci number is 0
            return 0;
        }

        if (n == 2) {
            // The 2nd Fibonacci number is 1
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= LIMIT; i++) {
            int fibo = fibonacci(i);
            System.out.println(fibo);
        }
    }
}