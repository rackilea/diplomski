import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static final int SIZE = 100;
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("C:\\Users\\Nick\\Desktop\\coords.txt"));
        int x = 0;
        int y = 0;
        int[] xCoords = new int[SIZE];
        int[] yCoords = new int[SIZE];
        int index = 0;
        while (s.hasNextLine()) {
            if (s.hasNextInt()) {
                x = s.nextInt();
            } else {
                System.out.println("had a next line, but no integers to read");
                break;
            }
            if (s.hasNextInt()) {
                y = s.nextInt();
            } else {
                System.out.println("had a next line, but no integers to read");
                break;
            }
            xCoords[index] = x;
            yCoords[index] = y;
            index++;
        }
        System.out.println("Output from what was read in from file:");
        for (int i = 0; i < index; ++i) {
            System.out.print(xCoords[i] + ", ");
            System.out.println(yCoords[i]);
        }
        s.close();
    }
}