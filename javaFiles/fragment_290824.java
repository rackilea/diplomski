public class Fibonacci1 {
    static long a[] = new long[100];

    public static long F(int N) {
        a[0] = 0; /* sets up first 2 digits in the sequence */
        a[1] = 1;
        if (N < 2) {
            return N;
        }
        a[N] = a[N - 1] + a[N - 2]; /* appends F num for next number in the list */
        return a[N]; /* should return the last number */
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++)
            System.out.println(N + " " + F(N));
        }
}