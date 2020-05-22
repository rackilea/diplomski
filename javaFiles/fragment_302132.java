Map<String, List<String>> map = new HashMap<String, List<String>>();

for (Map.Entry<String, List<String>> entry : map.entrySet()) {
    String key = entry.getKey();
    List<String> valueList = entry.getValue();
    for (String value : valueList) {
        // Do something with value
    }
}