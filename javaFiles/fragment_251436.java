import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;

    import org.apache.commons.csv.CSVFormat;
    import org.apache.commons.csv.CSVPrinter;

    public class TestMain {

        public static void main(String args[]) {

            HashMap<String, Integer> hmap = new HashMap<String, Integer>();
            hmap.put("Feature11", 1);
            hmap.put("Feature22", 2);
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(System.lineSeparator());
            Map<String, Integer> map = hmap;
            File temp;
            try {
                temp = File.createTempFile("tempfile", ".csv");
                FileWriter fs = new FileWriter(temp);

                CSVPrinter csvFilePrinter = new CSVPrinter(fs, csvFileFormat);
                csvFilePrinter.printRecord(map.keySet().toArray());
                csvFilePrinter.printRecord(map.values().toArray());
                csvFilePrinter.close();

                System.out.println(" temp " + temp);

                if (temp.exists()) {
                    Scanner input = new Scanner(temp);

                    while (input.hasNextLine()) {
                        System.out.println(input.nextLine());
                    }
                    input.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }