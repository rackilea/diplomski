import java.util.Scanner;

public class Selectionsort_descending {
public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter any number");
    int n = sc.nextInt();
    int a[] = new int[n];

    for (int i = 0; i < n ; i++) {
        System.out.println("Enter number");
        a[i] = sc.nextInt();
    }

    for (int j = 0; j < n ; j++) {
        for (int k = j; k < n; k++) {
            if (a[j] < a[k]) {
                int m = a[j];
                a[j] = a[k];
                a[k] = m;
            }
        }
    }

    for (int i = 0; i < n ; i++) {
        System.out.print(a[i] + " ");
    }

    sc.close();
}
}