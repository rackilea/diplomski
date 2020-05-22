import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();

        // Read lines
        List<String> dName = fileReader.read("taxi_details.txt");
        List<String> dest = fileReader.read("2017_journeys.txt");

        // Convert into proper format
        List<Line> dNameLines = dName.stream().map(Line::new).collect(Collectors.toList());
        List<Line> destLines = dest.stream().map(Line::new).collect(Collectors.toList());

        // Remove ID
        dNameLines.forEach(Line::emptyValue);

        // Merge lists
        Map<String, String> joined = join(dNameLines, destLines);

        // Print
        for (Entry<String, String> line: joined.entrySet()) {
            System.out.println(line.getKey() + " --> " + line.getValue());
        }
    }

    public static Map<String, String> join(List<Line> a, List<Line> b){
        Map<String, String> joined = new HashMap<>();

        // Put first list into map, as there is no danger of overwriting existing values
        a.forEach(line -> {
            joined.put(line.getName(), line.getValue());
        });

        // Put second list into map, but check for existing keys
        b.forEach(line -> {
            String key = line.getName();

            if(joined.containsKey(key)){    // Actual merge
                String existingValue = joined.get(key);
                String newValue = line.getValue();

                if(!existingValue.isEmpty()){
                    newValue = existingValue + Line.DELIMITER + newValue;
                }

                joined.put(key, newValue);
            }else{  // Add entry normally
                joined.put(line.getName(), line.getValue());
            }
        });

        return joined;
    }
}