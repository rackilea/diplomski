import java.util.Arrays;

public class ToAscii {
    public static void main(String[] args) {
        // Test
        System.out.println(Arrays.toString(toAscii("aBc")));
    }
    static int[] toAscii(String txt){
        int[] array = new int[txt.length()];
        int i = 0;

        char[] ascii1 = txt.toCharArray();

        for(char ch:ascii1){
            array[i] = ch;
            i++;
        }
        return array;
    }
}