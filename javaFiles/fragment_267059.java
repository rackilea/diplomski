import java.util.Arrays;

public class ToAscii {
    public static void main(String[] args) {
        // Test
        System.out.println(Arrays.toString(toAscii("aBc")));
    }

    static int[] toAscii(String txt) {
        int[] array = new int[txt.length()];
        char[] ascii1 = txt.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = ascii1[i];
        }
        return array;
    }
}