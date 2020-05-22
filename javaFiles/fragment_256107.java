import java.io.File;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;

public class OddsAndEvens {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("oddsAndEvens.dat"));
        int[] newRay = null;
        while (file.hasNext()) {
            String line = file.nextLine();
            String[] str = line.split("\\s+");
            newRay = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                newRay[i] = Integer.valueOf(str[i]);
            }
            System.out.println(Arrays.toString(newRay));
        }
    }
}