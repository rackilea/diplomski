import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Ex> list = new ArrayList<Ex>();

        Ex rec1 = new Ex("HR3-A1234", 0.00);
        Ex rec2 = new Ex("HR3-A1234", 0.01);
        Ex rec3 = new Ex("HR3-A1234", 1.00);
        Ex rec4 = new Ex("HR3-A2345", 0.00);
        Ex rec5 = new Ex("HR3-A2345", 0.01);
        Ex rec6 = new Ex("HR3-A3456", 0.01);
        Ex rec7 = new Ex("HR3-A3456", 1.00);
        Ex rec8 = new Ex("HR3-A4567", 0.01);

        list.add(rec1);
        list.add(rec2);
        list.add(rec3);
        list.add(rec4);
        list.add(rec5);
        list.add(rec6);
        list.add(rec7);
        list.add(rec8);

        displayMinMaxOfEach(list);
    }

    public static void displayMinMaxOfEach(List<Ex> exes) {
        // declare two maps for storing minumum and maximum values
        Map<String, Double> minExes = new HashMap<String, Double>();
        Map<String, Double> maxExes = new HashMap<String, Double>();

        // check each Ex in the list in order to get the minimum values
        exes.forEach((Ex ex) -> {
            if (minExes.containsKey(ex.getId())) {
                // if already contained, check if the new version is lower
                if (minExes.get(ex.getId()) > ex.getVersion()) {
                    // if it is lower, overwrite the old version number
                    minExes.put(ex.getId(), ex.getVersion());
                }
            } else {
                // if not already contained, just add it to the map
                minExes.put(ex.getId(), ex.getVersion());
            }
        });

        // check each Ex in the list in order to get the maximum values
        exes.forEach((Ex ex) -> {
            if (maxExes.containsKey(ex.getId())) {
                // if already contained, check if the new version is higher
                if (maxExes.get(ex.getId()) < ex.getVersion()) {
                    maxExes.put(ex.getId(), ex.getVersion());
                }
            } else {
                // if not already contained, just add it to the map
                maxExes.put(ex.getId(), ex.getVersion());
            }
        });

        // print minumum values from the minimum map
        System.out.println("Minimum versions:");
        minExes.forEach((id, version) -> {
            System.out.println(id + ": " + version);
        });

        // print maximum values from the maximum map
        System.out.println("Maximum versions:");
        maxExes.forEach((id, version) -> {
            System.out.println(id + ": " + version);
        });
    }
}