/**
 * Simple demo of extending a HashMap
 */
public class TokenizedStringHashMap extends HashMap<String, String> {

  void putAll(String tokenizedString, String delimiter) {
    String[] nameValues = tokenizedString.split(delimiter);
    for (String nameValue : nameValues) {
      String[] pair = nameValue.split("=");
      if (pair.length == 1) {
        // Duplicate the key name if there is only one value
        put(pair[0], pair[0]);
      } else {
        put(pair[0], pair[1]);
      }
    }
  }

  public static void main(String[] args) {
    TokenizedStringHashMap example = new TokenizedStringHashMap();

    example.putAll("a=1&b=3", "&");
    System.out.println(example.toString());
    example.clear();

    example.putAll("max-age=3600;must-revalidate", ";");
    System.out.println(example.toString());

  }
}