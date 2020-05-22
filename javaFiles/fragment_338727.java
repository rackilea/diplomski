import java.util.HashMap;
import java.util.Map;

class Swap {
    public static void main(String args[]) {

        HashMap<Integer, String> s = new HashMap<Integer, String>();

        s.put(4, "Value1");
        s.put(5, "Value2");

        for (Map.Entry en : s.entrySet()) {
            System.out.println(en.getKey() + " " + en.getValue());
        }

        /*
         * swap goes here
         */
        HashMap<String, Integer> newMap = new HashMap<String, Integer>();
        for(Map.Entry<Integer, String> entry: s.entrySet()){
            newMap.put(entry.getValue(), entry.getKey());
        }

        for(Map.Entry<String, Integer> entry: newMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}