import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String i = "this is a test string";
        String[] split  = i.split(" ");

        System.out.println("Before" + split.length);

        split = Arrays.copyOf(split, split.length - 1);

        System.out.println("After" + split.length);
    }

}