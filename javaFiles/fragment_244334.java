import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) throws IllegalArgumentException,
            IllegalAccessException {

        Map<String, DataStruc> newdatamap = new HashMap<String, DataStruc>();
        List<String> B1TradeRef = Arrays.asList("TradRefr", "tr1");
        List<String> B1TMS = Arrays.asList("TS", "TMSW");

        List<String> B2TradeRef = Arrays.asList("TradRefrtsy", "tr1ty");
        List<String> B2TMS = Arrays.asList("TWES", "TUYTMSW");

        newdatamap.put("B1", new DataStruc(B1TradeRef, B1TMS));
        newdatamap.put("B2", new DataStruc(B2TradeRef, B2TMS));

        Map<String, String> finalmap = new HashMap<String, String>();
        // loop through current map
        for (Map.Entry<String, DataStruc> entry : newdatamap.entrySet()) {

            String key = entry.getKey();
            DataStruc dataStruc = entry.getValue();

            // get all the fields of object dataStruc
            for (Field field : dataStruc.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                // check if field is List<String>
                if (field.get(dataStruc) instanceof List) {
                    List<String> fieldValue = (List<String>) field.get(dataStruc);
                    // if yes then add the List entries to your final map with
                    // current field name
                    for (String str : fieldValue) {
                        finalmap.put(str, fieldName);
                    }
                }

            }
        }

        for (Map.Entry<String, String> entry : finalmap.entrySet())
            System.out.println(entry.getKey() + "-" + entry.getValue());

    }

}