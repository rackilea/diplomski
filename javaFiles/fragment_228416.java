import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {

        String fileName = "Capitals.txt";

        int n = 50;
        String[] capital = new String[n];
        String[] state   = new String[n];

        try (Scanner inputStream = new Scanner(new FileInputStream(fileName))) {

            for (int i = 0; i < n; i++) {
                capital[i] = inputStream.nextLine();
                state[i]   = inputStream.nextLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        // do something with your arrays here
        // ...
        System.out.println(Arrays.toString(capital));
        System.out.println(Arrays.toString(state));
    }
}