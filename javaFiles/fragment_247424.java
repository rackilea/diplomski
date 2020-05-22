import java.util.Scanner;

public class Fibonnaci {
    public static void main(String[] args) {
        System.out
                .println("enter the upper bound of the serie(Size of the array of fibonacci serie):");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int fibonacci[] = new int[size];

        for (int i = 0; i < size; i++) {
            fibonacci[i] = fibonacci(i + 1, fibonacci);
        }

        System.out.println("enter a number between 1 and " + size);

        int j = scanner.nextInt();
        while (j < 0 || j > size) {
            if (j < 0) {
                System.out.println("j<0");
            }
            if (j > size) {
                System.out.println("j>" + size);
            }
            System.out.println("please enter a number between 1 and " + size);
        }
        System.out.println("Fibonacci[" + j + "]=" + fibonacci[j - 1]);
        scanner.close();
    }

    /*
     * changed the fibonacci function in order to use the already calculated
     * fibonacci elements
     * fibSerie[n]=fibonnaci[n-1]
     * fibSerie[n-1]=fibonnaci[n-2];
     * fibSerie[n-2]=fibonnaci[n-3];
     * because arrays start from 0 so fibSerie[1]=fibonnaci[0];
     */
    public static int fibonacci(int number, int[] fibonacci) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci[number - 2] + fibonacci[number - 3];

    }
}