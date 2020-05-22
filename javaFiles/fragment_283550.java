import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.FileReader;


...

try {
    CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
    String[] nextLine;
    while ((nextLine = reader.readNext()) != null) {
        // nextLine[] is an array of values from the line
        System.out.println(nextLine[0] + nextLine[1] + "etc...");
    }
} catch (IOException e) {

}