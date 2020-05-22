for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
  String key = entry.getKey();
  Integer value = entry.getValue();

  System.out.println(key + " => " + value);
}