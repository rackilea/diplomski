import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Main {
  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(4);
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(100);
    list2.add(400);
    list2.add(500);
    list2.add(700);

    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    map.put ("account_number", list1);
    map.put ("Amount", list2);

    System.out.println(map);

    List<String> list3 = new ArrayList<String>();
    List<Integer> list4 = new ArrayList<Integer>();

    String lastkey = null;
    int sequence = 0;
    for (final Entry<String, List<Integer>> entry : map.entrySet()) {
        final String key = entry.getKey();
        final List<Integer> value = entry.getValue();

        for (final Integer val : value) {
            list3.add(key);
            if(lastkey == null||lastkey!=key){
              sequence = 1;
              lastkey = key;
            } 
            list4.add(sequence++);
        }
    }

    System.out.println(list3);
    System.out.println(list4);
  }
}