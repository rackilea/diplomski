import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String str = "Irrelevant start|group 1|group 2 with \\| escaped|group 3|group 4|Irrelevant end";
        System.out.println(str);

        String[] arr = str.split("(?<!\\\\)\\|");

        String[] new_arr = Arrays.copyOfRange(arr, 1, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(new_arr));

    }
}