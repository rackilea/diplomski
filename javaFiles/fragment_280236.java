import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class comparison_rylan_howard {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(new
                File("H:\\NetBeansProjects\\Unit1\\comparison.txt"));
        try (PrintWriter writer = new PrintWriter("Results.txt")) {

            while (reader.hasNext()) {

                double first = reader.nextDouble();
                double second = reader.nextDouble();
                writer.println(first+","+second );
                if (first <= -1 || second <= -1) {
                    writer.println("Error");
                    writer.println("");
                }
                else if (first > second) {
                    writer.println(">");
                    writer.println("");
                }
                else if (first < second) {
                    writer.println("<");
                    writer.println("");
                } else {
                    writer.println("=");
                    writer.println("");
                }
            }
        }
    }
}