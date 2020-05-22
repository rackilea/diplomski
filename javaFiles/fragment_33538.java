import java.util.*;

public class Test {
  public static void main(String[] args) {
    Map<String, ArrayList<Integer>> unsortedMap = new HashMap<>();
    unsortedMap.put("A", new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
    unsortedMap.put("B", new ArrayList<Integer>(Arrays.asList(4)));
    unsortedMap.put("C", new ArrayList<Integer>(Arrays.asList(2, 3, 1, 4)));

    List<Map.Entry<String, ArrayList<Integer>>> list = 
        new ArrayList<>(unsortedMap.entrySet());
    Collections.sort(list, new EntryComparator());

    for (Map.Entry<String, ArrayList<Integer>> entry : list) {
      System.out.println(entry.getKey());
    }
  }

  private static class EntryComparator
      implements Comparator<Map.Entry<String, ArrayList<Integer>>>
  {
    public int compare(Map.Entry<String, ArrayList<Integer>> left,
        Map.Entry<String, ArrayList<Integer>> right) {     
      // Right then left to get a descending order
      return Integer.compare(right.getValue().size(), left.getValue().size());
    }
  }
}