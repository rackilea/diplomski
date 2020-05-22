import java.util.HashMap;

public class F {

  public static void main(String[] args) {

    String string = "aaaabbbccd";

    HashMap<Character, Integer> map = frequency(string);

    System.out.println(map);
  }

  public static HashMap<Character, Integer> frequency(String string) {
    int length = string.length();
    char c;

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    for (int i = 0; i < length; i++) {
      c = string.charAt(i);

      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);

      } else {

        map.put(c, 1);
      }
    }

    return map;
  }
}