import java.util.Arrays;

public class Rearrange
{

    public static void main(String args[]) {
       int arr[] = {1,2,3,4,1,2,3,4,5,6,5};
        reArrange(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reArrange(int[] arr, int x) {
        int index = 0;
        for (int current : arr)
            if (current != x)
                arr[index++] = current;
        Arrays.fill(arr, index, arr.length, x);
    }

}