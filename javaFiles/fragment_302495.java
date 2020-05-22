public void test() {
  Map<String, String> myMap = new HashMap<String, String>();

  for (String key : myMap.keySet()) {
    System.out.println(key);
    System.out.println(myMap.get(key));
  }

  Set<String> keySet = myMap.keySet();
  for (String key : keySet) {
    System.out.println(key);
    System.out.println(myMap.get(key));
  }
}