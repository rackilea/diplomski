import java.util.Arrays;

public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] bigger_array = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] smaller_array = { 1, 2, 3 };
        // start copying from position 1 in source, and into 
        // position 3 of the destination, and copy 2 elements.
        int srcPos = 1, destPos = 3, length = 2;
        System.arraycopy(smaller_array, srcPos, bigger_array, destPos, length );
        System.out.println( Arrays.toString( bigger_array ));
    }
}