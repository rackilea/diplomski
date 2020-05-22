import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class test {
    public static void main(String[] args) {
        Map<String, List<List<Double>>> alphabet = new HashMap<String,List<List<Double>>>();
        List<List<Double>> something = new ArrayList<List<Double>>();
        List<Double> stuffList = new ArrayList<Double>();
        stuffList.add(3.1);
        stuffList.add(3.2);
        stuffList.add(3.3);
        something.add(stuffList);
        alphabet.put("A", something);
        System.out.println(something);
        System.out.println(alphabet);
        // Create new instances:
        something = new ArrayList<List<Double>>();
        stuffList = new ArrayList<Double>();
        stuffList.add(3.4);
        something.add(stuffList);
        alphabet.put("B", something);
        System.out.println(something);
        System.out.println(alphabet);
    }
}