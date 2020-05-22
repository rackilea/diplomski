import java.util.*;

public class Selection {
    public static void main(String[] args) {
        int[] a = new int[20];
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter element number  " + i + " : ");
            a[i] = in.nextInt();
        }

        // if you want to display the array after filling, there are 2 standard ways
        for (int element : a) {
            System.out.println(element); // displays each on a new line
        }

        // or, using Arrays.toString() (from the java.util package)
        System.out.println(Arrays.toString(a));
    }
}