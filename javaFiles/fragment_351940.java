import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdvanceCollection {
    static List<String> arr = new ArrayList<String>();

    public static void main(String[] args) {

        try {

            File file = new File("path of your file");

            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                // here we are getting the full line
                String s[] = input.nextLine().split(" ");
                for (String text : s) {
                    arr.add(text);

                }

            }
            input.close();
            // here you can get the value by get method
            System.out.println(arr.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}