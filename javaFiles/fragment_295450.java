import java.util.Scanner;


public class Main {
    int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};

    public int binarySearch(int key, int l, int r) {
        if (r < l) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (key == array[mid]) {
            return mid;
        }
        if (key < array[mid]) {
            return binarySearch(key, l, mid - 1);
        } else {
            return binarySearch(key, mid + 1, r);
        }

    }

    public static void main(String[] args) {
        Main b = new Main();
        System.out.println("input the element you want to search :");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        System.out.println("Search for element " + i);
        System.out.println("This element is found at " + b.binarySearch(i, 0, 14));
        System.out.println("=======+============+=======+==============");
        in.close();
    }
}