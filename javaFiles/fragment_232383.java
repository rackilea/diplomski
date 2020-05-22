import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareFiles {

    public static void main(String[] args) {
        boolean same = true;
        Scanner in = null;

        try {
            in = new Scanner(new FileReader("first.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> firstLines = new ArrayList<String>();
        while (in.hasNextLine()) {
            firstLines.add(in.nextLine());
        }
        in.close();

        try {
            in = new Scanner(new FileReader("second.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int counter = 0;
        while (in.hasNextLine()) {
            if (counter < firstLines.size()) {
                if (!((in.nextLine()).equals(firstLines.get(counter)))) {
                    same = false;
                    break;
                }
                counter++;
            } else {
                break;
            }
        }
        in.close();
        System.out.println(same);
    }
}