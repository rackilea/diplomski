import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumArray {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java NumArray <file>");
        }
        else {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                ArrayList<Float> numbers = new ArrayList<>();
                String line = br.readLine();
                while (line != null) {
                    String[] parts = line.split(" ");
                    for (String part : parts) {
                        numbers.add(Float.valueOf(part)); // throws java.lang.NumberFormatException
                    }
                    line = br.readLine();
                }
                Float[] numArray = new Float[numbers.size()];
                numbers.toArray(numArray);
                for (Float number : numbers) {
                    System.out.print(number);
                    System.out.print(" ");
                }
                System.out.println();
            }
            catch (IOException xIo) {
                xIo.printStackTrace();
            }
        }
    }
}