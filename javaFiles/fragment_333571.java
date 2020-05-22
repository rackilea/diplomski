import java.util.Map;
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap();
    map.put("a", 12);
    map.put("b", 3);
    map.put("c", 24);
    System.out.println(map.entrySet().stream().filter(x -> x.getValue() > 0).mapToInt(x -> x.getValue()).sum());
  }
}