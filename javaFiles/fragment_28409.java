import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Aroniaina
 */
public class RandomOperator {

    public static HashMap<Integer, List<Integer>> possibilities(Integer current) {
        //Return -1 and 1 if current si equal to 1
        if (current == 1) {
            HashMap<Integer, List<Integer>> result = new HashMap<>();
            //Add positive possibility
            List<Integer> list1 = new ArrayList<>();
            list1.add(current);
            result.put(current, list1);
            //Add negative possibility
            List<Integer> list2 = new ArrayList<>();
            list2.add(-1 * current);
            result.put(-1 * current, list2);
            return result;
        } else {
            HashMap<Integer, List<Integer>> previous = possibilities(current - 1);
            HashMap<Integer, List<Integer>> temp = new HashMap<>();
            temp.putAll(previous);
            for (Integer prev : previous.keySet()) {
                if (previous.get(prev).size() == (current - 1)) {
                    //Add positive possibility                
                    List<Integer> list1 = new ArrayList<>();
                    list1.addAll(previous.get(prev));
                    list1.add(current);
                    temp.put(current + prev, list1);
                    //Add negative possibility
                    List<Integer> list2 = new ArrayList<>();
                    list2.addAll(previous.get(prev));
                    list2.add(-1 * current);
                    temp.put(-1 * current + prev, list2);
                }
            }
            return temp;
        }
    }

    public static void main(String args[]) {
        for (int i = 0; i < 20; i++) {
            Integer toVerify = i;
            int current = 1;
            while (true) {
                HashMap<Integer, List<Integer>> result = possibilities(current);
                if (result.keySet().contains(toVerify)) {
                    System.out.print(toVerify + " = ");
                    for (Integer e : result.get(toVerify)) {
                        System.out.print(e > 0 ? ("+" + e) : (e));
                    }
                    break;
                }
                current++;
            }
            System.out.println("");
        }
    }
}