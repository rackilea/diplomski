import java.util.Random;

public class Test2 {
    private static void doTest(double[] array, Random r) {
        double someArray[] = new double[1];
        double someArray2[] = new double[2];

        for (int i = 0; i < someArray2.length; i++) {
            someArray2[i] = r.nextDouble();
        }

        ... // rest of your code
    }

    Test2() {
        double array[] = new double[1];
        Random r = new Random();

        while (true) {
            doTest(array, r);
        }
    }

    public static void main(String[] args) {
        new Test2();
    }
}