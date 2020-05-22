import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int studentNumbers = input.nextInt();
    input.nextLine();
    List<String> names = new ArrayList<String>();
    int[] volume = new int[100];
    // clear all data to make it clean
    names.clear();
    while (true) {

        if (studentNumbers == 0)
            break;
        else
            for (int i = 0; i < studentNumbers; i++) {
                String studentName = input.next();
                // here is how prevent string duplicates in names[] array like
                if (names.contains(studentName)) {
                    continue;
                }
                if (studentName.length() > 10) {
                    break;
                }
                names.add(studentName);
                int length = input.nextInt();
                int width = input.nextInt();
                int height = input.nextInt();

                System.out.printf("\n%s %d %d %d\n", names.get(i), length, width, height);
                volume[i] = length * height * width;
            }
        int minimum = 0, maximum = 0;
        for (int i = 1; i < studentNumbers; ++i) {
            if (volume[i] < volume[minimum])
                minimum = i;
            if (volume[i] > volume[maximum])
                maximum = i;
        }
        if (volume[minimum] == volume[maximum])
            System.out.println("\nno child lost his jelly\n");
        else
            System.out.printf("\n%s has lost jelly to %s.\n", names.get(minimum), names.get(maximum));
        studentNumbers = input.nextInt();
        input.nextLine();

    }

}