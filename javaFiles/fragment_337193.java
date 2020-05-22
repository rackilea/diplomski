import java.util.*;

public class test {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);

        int j = 1;
        int[] list = new int[11];

        System.out.println("Enter 10 integers - one at a time...");

        for (int i = 0; i < list.length - 1; i++) {

            System.out.print("Enter integer #" + j + ": ");
            list[0] = input.nextInt();
            j++;

            //SortMethod.sort(list, list.length);
            SelectionSort.sort(list);
            //BubbleSort.sort(list);
            System.out.print("Sorted numbers: ");

            for (int p = 1; p < list.length; p++) {
                if (list[p] != 0)

                    System.out.print(list[p] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("Done!");
    }
}

class SelectionSort {

    public static void sort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    int temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                    i--;
                    break;
                }
            }
        }
    }
}