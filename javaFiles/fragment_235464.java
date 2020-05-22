import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StoreToFIle {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }

        storeTextLinesToFile(list, "store.txt");
    }

    static void storeTextLinesToFile(List<String> listOfTextLines, String fileName) {
        try {
            PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));

            for (String line : listOfTextLines) {
                outputFile.println(line);
            }

            outputFile.close();

        } catch (IOException ioException) {
            System.out.println("\n\n Cannot write to file \"" + fileName + "\"");
        }
    }
}