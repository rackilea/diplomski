import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] array1 = {5, 1, 4, 5, 7, 8, 1, 0, 4};
        int [] array2 = {4, 7, 1, 0, 9, 3};

        System.out.println("Array 1");
        print(array1);

        System.out.println("Array 2");
        print(array2);

        Arrays.sort(array1);
        Arrays.sort(array2);

        System.out.println("Sorted array 1");
        print(array1);

        System.out.println("Sorted array 2");
        print(array2);

        int [] mergedAndSortedArray = mergeSorted(array1, array2);

        System.out.println("Sorted merged array");
        print(mergedAndSortedArray);
    }

    private static void print(int [] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println("\n");
    }

    private static int [] mergeSorted(int [] array1, int [] array2) {
        int [] res = new int [array1.length + array2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        //Do your homework. First loop until you reach end of either array, and then add the rest elements.

        return res;
    }
}