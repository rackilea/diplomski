import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParseCSVFile {

    public static void main(String[] args) {

        // Get the csv file path
        String fileName = "yourCsvFile.csv";

        // method returns list of strings in csv file
        List<List<String>> lines = parseCsvFile(fileName);

        // Method to print the contents
        printCSVListContents(lines);

    }

    /**
     * Prints the CSV list contents.
     *
     * @param listOfLines the list of lines
     */
    private static void printCSVListContents(final List<List<String>> listOfLines) {
        int initialLineNo = 1;
        for (List<String> line : listOfLines) {
            int columnNo = 1;
            for (String contentsOfLine : line) {
                System.out.println("Line Number: " + initialLineNo + " Column Number: " + columnNo + " Contents: " +  contentsOfLine);
                columnNo++;
            }
            initialLineNo++;
        }
    }

    /**
     * Parses the CSV file.
     *
     * @param inputLineNumber the file name
     * @return the list
     */
    private static List<List<String>> parseCsvFile(final String inputLineNumber) {
        File file = new File(inputLineNumber);

        // To provide a 2-dimensional array of strings
        List<List<String>> lineList = new ArrayList<>();
        Scanner scannerStream;

        try {
            scannerStream = new Scanner(file);
            while (scannerStream.hasNext()) {
                String line = scannerStream.next();
                String[] values = line.split(",");
                lineList.add(Arrays.asList(values));
            }
            scannerStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lineList;

    }
     }