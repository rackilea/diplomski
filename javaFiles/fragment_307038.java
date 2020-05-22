import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner Y = new Scanner(new File("C:\\R5_M.txt"));
        Scanner X = new Scanner(new File("C:\\R5_O.txt"));
        double a = 0.0, b = 0.0, c, d = 0.0, e = 0.0, f, g, h;

        // Create a map to hold the values from each file
        HashMap<String, Double> yList = new HashMap<>();
        HashMap<String, Double> xList = new HashMap<>();

        // Read in the data from both files
        while (Y.hasNext()) {
            // This will place the values into the HashMap. The first value is whatever "key"
            // you want to use, the second is the value itself.
            yList.put("a", Y.nextDouble());
            yList.put("b", Y.nextDouble());
            yList.put("c", Y.nextDouble());
        }

        while (X.hasNext()) {
            xList.put("a", X.nextDouble());
            xList.put("b", X.nextDouble());
            xList.put("c", X.nextDouble());
        }

        // Now, you can compare values in both maps
        // The HashMap has a list called entrySet that allows you to iterate over all
        // of the entries in the list
        for (Map.Entry<String, Double> entry : yList.entrySet()) {
            // This will check if the current entry's key/value pair matches the identical
            // key/value pair in the xList map.
            if (entry.getValue() == xList.get(entry.getKey()).doubleValue()) {
                System.out.println(entry.getKey() + " matches!");
            } else {
                System.out.println(entry.getKey() + " does NOT match!");
            }
        }

    }
}