public class Homework1C {
    public static void main(String[] args) {
        double term = 2, sum = 0;
        final double difference = 0.0000000001;
        int n;

        for (n = 0; term > difference; n++) {
            term = 1.0 / find_n_fact(n);
            sum += term;
        }

        System.out.printf("e : %f\n", sum);
        System.out.printf("term : %d\n", n);
    }

    public static double find_n_fact(int n) {

        if (n == 0 || n == 1)
            return 1.0;

        return n * find_n_fact(n - 1);
    }
}