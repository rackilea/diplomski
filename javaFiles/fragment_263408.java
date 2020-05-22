import java.util.Scanner;

public class Sorting {

    public static void main(String[] args) {

        int n, c;
        Scanner scan = new Scanner(System.in);

        System.out.print("Number of elements: ");
        n = scan.nextInt();
        int[] array = new int[n];

        System.out.print("Enter " + n + " elements: ");

        for (c = 0; c < n; c++) {
            array[c] = scan.nextInt();
        }

        BubbleSort(array);
    }

    static void BubbleSort(int[] array) {

        int n = array.length;

        for (int c = 0; c < (n - 1); c++) {
            for (int d = 0; d < n - c - 1; d++) {
                if (array[d] > array[d + 1]) {
                    int swap = array[d];
                    array[d] = array[d + 1];
                    array[d + 1] = swap;
                }
            }
        }

        System.out.print("Bubble sort: ");

        for (int c = 0; c < n; c++) {
            System.out.print(array[c] + " ");
        }
    }
}