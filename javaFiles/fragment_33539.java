import java.util.*;
import java.util.stream.*;

public class Test {
  public static void main(String[] args) {
    Map<String, ArrayList<Integer>> unsortedMap = new HashMap<>();
    unsortedMap.put("A", new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
    unsortedMap.put("B", new ArrayList<Integer>(Arrays.asList(4)));
    unsortedMap.put("C", new ArrayList<Integer>(Arrays.asList(2, 3, 1, 4)));

    List<String> keys = unsortedMap
          .entrySet()
          .stream()
          .sorted((left, right) ->
              Integer.compare(right.getValue().size(), left.getValue().size()))
          .map(entry -> entry.getKey())
          .collect(Collectors.toList());

    for (String key : keys) {
      System.out.println(key);
    }
  }
}