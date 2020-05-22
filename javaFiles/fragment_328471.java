for (Map.Entry<String, String> entry1 : map1.entrySet() {
  String key = entry1.getKey();
  String value1 = entry1.getValue();
  String value2 = map2.get(key); 
  // do whatever with value1 and value2 
}