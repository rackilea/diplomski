public class MapRegistry {
  static Map<String,HashMap<Integer,String>> allMaps = new HashMap<>();

  public static void register(String name, HashMap<Integer,String> myMap) {
    allMaps.put(name, myMap);
  }

  public static HashMap<Integer,String> find(String name) {
    return allMaps.get(name);
  }
}