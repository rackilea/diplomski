import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapSetExample
{
  public static void main(String[] args)
  {
    Map<String, Set<String>> map = new HashMap<String, Set<String>>();
    System.out.println("ADDED = " + add(map, "Train1", "Station1"));
    System.out.println("ADDED = " + add(map, "Train1", "Station2"));
    System.out.println("ADDED = " + add(map, "Train1", "Station1"));

    System.out.println("Stations of Train1 = " + map.get("Train1"));

  }

  private static boolean add(Map<String, Set<String>> map, String key, String station) {
    Set<String> set = map.get(key);

    /* If map.get() returns null, that means there is no set
     * in the map associated with given key.
     * 
     * In that case we create a new set.
     * 
     * If there is already a set, we use that one.
     */
    if (set == null) {
      set = new TreeSet<String>();
      map.put(key, set);
    }
    /* False if station is already in set. At this point you could also delete sth. etc. */
    boolean success = set.add(station);
    return success;
  }
}