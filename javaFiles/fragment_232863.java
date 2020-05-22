void printHashMap(String mapChoice){
  HashMap<Integer,String> map = MapRegistry.find(mapChoice);
  for (Integer ID : map.keySet()) {
    String key = ID.toString();
    String value = map.get(ID);
    System.out.println(key + " " + value);
  }
}