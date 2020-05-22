import java.util.Arrays;
import java.util.Random;

public class RandomPicker {

    public static void main(String[] args) {

        int[] arr = {6, 1, 5, 3, 4, 2};
        int[] copy = Arrays.copyOf(arr, arr.length);
        shuffle(copy);
        int index = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            System.out.printf("%d, %d\n",copy[index], copy[++index]);
        }
    }

    private static void shuffle(int[] arr)
    {
        int index;
        int temp;
        Random rand = new Random();
        int i = arr.length - 1;
        while ( i > 0)
        {
            index = rand.nextInt(i + 1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            i--;
        }
    }
}