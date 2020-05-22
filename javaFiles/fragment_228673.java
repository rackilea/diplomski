import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 1, 2, 4, 3, 5, 6, 2, 2, 2, 1, 1, 1};
        quickSort(arr);
        System.out.print("Sorted array: ");
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start > end)
            return; // base condition

        System.out.print("Recursive call on: ");
        IntStream
                .rangeClosed(start, end)
                .map(i -> arr[i])
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        int n = arr.length;
        if (start < 0 || start >= n || end < 0 || end >= n)
            throw new IllegalArgumentException("the indices of the array are not valid");

        int pivot = arr[end];
        /*
            [start,left) - sub-array with elements lesser than pivot
            [left, mid) - sub-array with elements equal to pivot
            [mid, right] - sub-array with elements greater than pivot
            [right, end) - elements yet to be explored.
         */
        int left = start, mid = start, right = start;

        while (right != end) {
            if (arr[right] < pivot) {
                swap(arr, left, right);
                swap(arr, mid, right);
                left++;
                right++;
                mid++;
            } else if (arr[right] == pivot) {
                swap(arr, mid, right);
                mid++;
                right++;
            } else if (arr[right] > pivot) {
                right++;
            }
        }

        swap(arr, mid, right);
        System.out.println("Placed " + pivot + " at it's correct position");
        System.out.println();
        quickSort(arr, start, left - 1);
        quickSort(arr, mid + 1, end);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}