public class MainTest {

  public static void main(String[] args) {

    HashMap<String,Double> hashMap = new HashMap<>();

    hashMap.put("One", 10.0);
    hashMap.put("Two", 8.0);
    hashMap.put("Three", 9.0);
    hashMap.put("Four", 7.0);
    hashMap.put("Five", 10.1);

    System.out.println(getSmallestDiffKeyJava8(hashMap, "One"));

  }

  /* This works only with java 8 */
  private static String getSmallestDiffKeyJava8(Map<String, Double> map, String constantKey) {
    double constant = map.get(constantKey);

    return map.entrySet().stream()
        .filter(entry -> !constantKey.equals(entry.getKey())) // Remove the constant from the values we process
        .map(entry -> new SimpleEntry<>(entry.getKey(), Math.abs(entry.getValue() - constant))) // Map to a new entry with the key and the diff
        .min((o1, o2) -> (int)(o1.getValue() - o2.getValue())) // Find the min
        .map(Entry::getKey)
        .get();


  }

  /* This works with older versions as well */
  private static String getSmallestDiffKey(Map<String, Double> map, String constantKey) {
    double constant = map.get(constantKey);
    String key = null;
    Double diff = null;

    for (Entry<String, Double> entry : map.entrySet()) {
      if (!constantKey.equals(entry.getKey())) {
        double d = Math.abs(entry.getValue() - constant);
        if (diff == null || diff > d) {
          diff = d;
          key = entry.getKey();
        }
      }
    }

  return key;
  }

}