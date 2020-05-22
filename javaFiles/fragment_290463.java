import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("The correct syntax to use this program is: java Main <filename.txt> <text-to-search>");
            return;
        }
        Scanner scanner;
        File file = new File(args[0]);
        int rowCount = 1, index;
        String line;

        // Map to collect row and col info of the search string
        Map<String, String> lineColMap = new HashMap<String, String>();

        if (!file.exists()) {
            System.out.println("The file, " + args[0] + " does not exist");
            return;
        }
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {// Loop until the last line in the file
                line = scanner.nextLine();// Read a line from the file
                index = line.indexOf(args[1]);// Find if the string exists in the line
                if (index != -1) {// If the string exists
                    // Put the row and col info of the search string into the map
                    lineColMap.put("Row: " + rowCount, "Column: " + index);
                }
                rowCount++;// Increase the row count
            }
        } catch (Exception e) {
            System.out.println("Error occured while processing the file");
            e.printStackTrace();
        }
        if (lineColMap.entrySet().size() > 0) {// If there is at least one entry collected into the map
            System.out.println("'" + args[1] + "' exists in " + args[0] + " as follows:");
            for (Map.Entry<String, String> entry : lineColMap.entrySet()) {
                System.out.println(entry.getKey() + ", " + entry.getValue());
            }
        } else {
            System.out.println("'" + args[1] + "' does not exist in " + args[0]);
        }
    }
}