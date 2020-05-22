public class MapHierarchy {
public static void main(String[] args) {
    // preparation
    Map<String, Map<String, List<String>>> myTestMap = new HashMap<>();
    ArrayList<String> listOfValues = new ArrayList<>();
    listOfValues.add("Hello");
    listOfValues.add("my");
    listOfValues.add("little");
    listOfValues.add("friend");

    HashMap<String, List<String>> innerMap = new HashMap<>();
    innerMap.putIfAbsent("innerMapKey", listOfValues);
    myTestMap.put("outerKey", innerMap);

    // where the magic happens
    System.out.println("Keys of outer map: " + myTestMap.keySet().toString());
    for (Map.Entry<String, List<String>> innerMapItem : innerMap.entrySet()) {
        String innerMapItemKey = innerMapItem.getKey();
        System.out.println("Key of inner map: " + innerMapItemKey);
        System.out.println("Values of inner map: " + innerMapItem.getValue().toString());
    }
}}