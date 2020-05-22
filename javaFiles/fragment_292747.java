import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[8];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter an integer: ");
            arr[i] = in.nextInt();
        }

        System.out.println("Largest in given array is " + max(arr));
    }

    public static int max(int arr[]) {
        if (arr.length == 0) {
            return -1;
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}