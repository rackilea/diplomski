import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

    static Map<String, String> map = new HashMap<String, String>();

    public static void main(String[] args) {

        String csvFile = "/home/../country.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                for (int i = 0; i < country.length; i++) {
                    map.put(country[4], country[5]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String code = entry.getKey();
            String name = entry.getValue();
            System.out.println("Country [code= " + code + " , name=" + name + "]");
        }
    }

}