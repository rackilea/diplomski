import java.util.*;
import java.io.*;

public class MapTesting {
    public static void main(String[] args) {
        PrintStream output = new PrintStream(System.out);
        Scanner input = new Scanner(System.in);

        Map<Integer, Integer> normal = new LinkedHashMap<Integer, Integer>();
        output.println("Enter your map, one key-value pair per line,");
        output.println("comma-separated. Use empty line as sentinel.");

        for ( String entry = input.nextLine(); entry.length() !=0;
              entry = input.nextLine()) {
            int comma = entry.indexOf(",");
            Integer key = Integer.parseInt(entry.substring(0,comma));
            Integer value = Integer.parseInt(entry.substring(comma+1));
            normal.put(key,value);
        }
        output.println("The input map is:");
        output.println(normal);

        // Here we make our reverse map an instance of our custom DescendingKeysMap.
        Map<Integer, Integer> reverse = new DescendingKeysMap();
        for (Map.Entry<Integer, Integer> entry : normal.entrySet()) {
            Integer keyY = entry.getKey();
            Integer valueE = entry.getValue();
            Integer existingReverseValue = reverse.get(valueE);

            if (existingReverseValue != null) {
                int currentValue = existingReverseValue;
                int potentialNewValue = keyY;
                if ( potentialNewValue < currentValue) {
                    reverse.put(valueE,keyY);
                }
            } else {
                reverse.put(valueE,keyY);
            }
        }
        output.println("The inverted map [using the smaller key as a tie breaker]:");
        output.println(reverse);
    }

    /**
     * Extends HashMap<Integer, Integer> and Overrides entrySet() to return the entries sorted by keys descending.
     */
    public static class DescendingKeysMap extends HashMap<Integer, Integer>{

        @Override
        public Set<Map.Entry<Integer, Integer>> entrySet() {
            List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(super.entrySet());
            // Sort
            Collections.sort(entries, new ByKeysDescending());
            return new LinkedHashSet<Map.Entry<Integer,Integer>>(entries);
        }
    }

    /**
     * Implements Comparator<Map.Entry<Integer, Integer>> to compare by the keys descending.
     */
    public static class ByKeysDescending implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
            // return the opposite of comparing the keys, to get a descending order
            return e1.getKey().compareTo(e2.getKey()) * -1;
        }
    }
}