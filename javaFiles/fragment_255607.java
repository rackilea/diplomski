import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author runef
 */
public class Test {

    public static void main(String[] args) {
        new Test();
    }

    private List<CoolObject> coolObjects = new ArrayList<>();
    private String[] linesOfCSV = {"A,B,C,D", "1,2,A,A", "2,1,B,B"};

    public Test() {
        String[] keys = null;
        for (String s : linesOfCSV) {
            String[] lineValues = s.split(",");
            if (keys == null) {
                keys = lineValues;
            } else {
                Map<String, String> aGoodName = new HashMap<>();
                for (int i = 0; i < lineValues.length; i++) {
                    //TODO: Check if keys[i] exists, check if lineValues[i] exists (if not probs something wrong with CSV)
                    aGoodName.put(keys[i], lineValues[i]);
                }
                coolObjects.add(new CoolObject(aGoodName));
            }
        }
        Collections.sort(coolObjects, new SortByKey("A"));
        System.out.println("SORTED BY KEY 'A'");
        for (CoolObject o : coolObjects) {
            for (Map.Entry<String, String> entry : o.getACoolMap().entrySet()) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + "   ");
            }
            System.out.print("\n");
        }
        Collections.sort(coolObjects, new SortByKey("B"));
        System.out.println("SORTED BY KEY 'B'");
        for (CoolObject o : coolObjects) {
            for (Map.Entry<String, String> entry : o.getACoolMap().entrySet()) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + "   ");
            }
            System.out.print("\n");
        }
    }

    class CoolObject {

        private Map<String, String> aCoolMap;

        public CoolObject(Map<String, String> aCoolMap) {
            this.aCoolMap = aCoolMap;
        }

        public Map<String, String> getACoolMap() {
            return aCoolMap;
        }
    }

    class SortByKey implements Comparator<CoolObject> {

        private String keySorter;

        public SortByKey(String keySorter) {
            this.keySorter = keySorter;
        }

        public int compare(CoolObject a, CoolObject b) {
            //TODO: CHECK IF KEY EXISTS IN BOTH VALUES! ELSE DO SOMETHING ELSE :) PROBS RETURN -1 SO IT COMES LAST!
            return a.getACoolMap().get(this.keySorter).hashCode() - b.getACoolMap().get(this.keySorter).hashCode();
        }
    }
}