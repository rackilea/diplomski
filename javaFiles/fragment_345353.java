import java.util.Arrays;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] ars) {
        int n = 30;
        double x = 0.9;

        double[] aux = makeAux(n, x);
        int[] results = new int[n];
        for (float i = 1; i <= 10000; i++) {
            results[pickANumber(aux)]++;
        }
        for (int i = 0; i < results.length; i++) {
            System.out.println(i + "\t" + results[i]);
        }
    }

    static double[] makeAux(int n, double x) {
        double[] aux = new double[n];
        aux[0] = x;
        for (int i = 1; i < n; i++)
            aux[i] = aux[i - 1] + Math.pow(x, (i + 1));
        return aux;
    }

    static int pickANumber(double[] aux) {
        double number = random.nextDouble() * aux[aux.length - 1];
        int i = Arrays.binarySearch(aux, number);
        if (i < 0)
            i = -i - 1;
        return i;
    }
}