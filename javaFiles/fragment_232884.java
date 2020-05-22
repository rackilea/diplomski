import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExampleMain {

public static void main(String[] args) {
    // create a Path object from the path to your file
    Path csvFilePath = Paths.get("Y:\\our\\path\\to\\file.csv");
    // create a data structure that stores data rows per traffic level
    Map<Integer, List<DataRow>> dataRowsPerTrafficLevel = new TreeMap<Integer, List<DataRow>>();

    try {
        // read all the lines of the file
        List<String> lines = Files.readAllLines(csvFilePath);

        // iterate all the lines, skipping the header line
        for (int i = 1; i < lines.size(); i++) {
            // split the lines by the separator (WHICH MAY DIFFER FROM THE ONE USED HERE)
            String[] lineValues = lines.get(i).split(",");
            // store the value from column 6 (index 5) as the traffic level
            int trafficLevel = Integer.valueOf(lineValues[5]);
            // if the map already contains this key, just add the next data row
            if (dataRowsPerTrafficLevel.containsKey(trafficLevel)) {
                DataRow dataRow = new DataRow();
                dataRow.subId = lineValues[1];
                dataRow.countryId = lineValues[2];
                dataRow.type = lineValues[3];
                dataRowsPerTrafficLevel.get(trafficLevel).add(dataRow);
            } else {
                /* otherwise create a list, then a data row, add it to the list and put it in
                 * the map along with the new key
                 */
                List<DataRow> dataRows = new ArrayList<DataRow>();
                DataRow dataRow = new DataRow();
                dataRow.subId = lineValues[1];
                dataRow.countryId = lineValues[2];
                dataRow.type = lineValues[3];
                dataRows.add(dataRow);
                dataRowsPerTrafficLevel.put(trafficLevel, dataRows);
            }
        }

        // print the result
        dataRowsPerTrafficLevel.forEach((trafficLevel, dataRows) -> {
            System.out.println("For TrafficLevel " + trafficLevel + " there are " + dataRows.size()
                    + " data rows in the csv file");
        });

    } catch (IOException e) {
        e.printStackTrace();
    }
}

/*
 * small holder class that just holds the values of columns 3, 4 and 5.
 * If you want to have distinct values, make this one a full POJO implementing Comparable
 */
static class DataRow {
    String subId;
    String countryId;
    String type;
}