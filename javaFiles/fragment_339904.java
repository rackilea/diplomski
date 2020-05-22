/**
 * Doing that in a 'homework' way
 */
public class ShwetaNoCheats {

    private static Integer i = 185;

    public static void main(String... args) {
        int length = 0;
        while (i != 0) {
            System.out.println(i - (i / 10) * 10);
            i /= 10;
            length++;
        }
        System.out.println("Length is: " + length);
    }
}