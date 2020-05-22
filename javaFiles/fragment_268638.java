import java.util.*;

class Test {

  static String getByPath(HashMap<String, Object> map, String... path) {
    for(int i=0; i<path.length-1; i++) {
      map = (HashMap<String, Object>) map.get(path[i]);
      if (map == null) return null;
    }
    Object value = map.get(path[path.length-1]);
    return value == null ? null : String.valueOf(value);
  }

  public static void main(String[] args) {
    HashMap<String, Object> map = new HashMap<>();
    HashMap<String, Object> tmp1 = new HashMap<>();
    HashMap<String, Object> tmp2 = new HashMap<>();
    map.put("test1", tmp1);
    tmp1.put("test2", tmp2);
    tmp2.put("key1", "My Value");

    System.out.println("With valid path:   " + getByPath(map, "test1", "test2", "key1"));
    System.out.println("With invalid path: " + getByPath(map, "test1", "BANANA", "key1"));
  }
}