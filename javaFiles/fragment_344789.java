import java.util.Arrays;

public class Test {

    int[] array1 = { 1, 2, 3 };
    String[] array2 = { "Hello", "World" };

    @Override
    public String toString() {
        return Arrays.toString(array1) + " " + Arrays.toString(array2);
    }

    public static void main(String[] args) {
        System.out.println(new Test());
    }
}