import java.util.Arrays;
import java.util.Random;

public class SelectionSort { 

    public static void main(String[] args) {
        int[] array = new int[200];

        Random rand = new Random();

        // for acsending order
        for (int i = 0; i < array.length; i++) {

            array[i] = rand.nextInt(1000000) + 1;
        }

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.print("\n");


        // for descending order

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + ", ");
            if (i % 4 == 0) { 
                // print \n for each 4 numbers.
                System.out.println("\n");
            }
        } 
    }
}