import java.util.*;
import java.util.stream.*;

interface CountRepeats {
    static void main(String[] args) {
        test(0, 1, 2, 2, 1, 2, 2, 1, 3, 3, 1);
        test(0, 1, 1, 1, 1, 2);
    }
    static void test(int... digits) {
        System.err.println(
            countRepeats(digits)+": "+Arrays.toString(digits)
        );
    }
    static long countRepeats(int[] array) { 
        return IntStream.range(0, array.length-1)
            .filter(i ->
                array[i] == array[i+1] && (
                   i+2 >= array.length ||
                   array[i] != array[i+2]
                )
             )
             .count();
    }
}