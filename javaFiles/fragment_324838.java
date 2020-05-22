import java.util.Scanner;

/**
 * @author Davide
 */
public class test {
    public static void main(String[] args) {
        int index[] = {12, 13, 14, 15, 16};

        Scanner a = new Scanner(System.in);
        System.out.println("enter the number");
        int b = a.nextInt();

        // one if and else
        if (find(index, 0, b)) {
            System.out.println("Number Found");
        } else {
            System.out.println("Number not Found!!!");
        }
    }

    // one loop
    public static boolean find(int[] array, int index, int value) {
        return index < array.length && (array[index] == value || find(array, ++index, value));
    }
}