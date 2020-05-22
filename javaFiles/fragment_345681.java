Map <Integer,String> myMap = new HashMap<Integer,String>();

Iterator<Entry<Integer, String>> iterator = myMap.entrySet().iterator();
while (iterator.hasNext()) {
    Map.Entry<Integer,String> pairs = (Map.Entry<Integer,String>)iterator.next();
    String value =  pairs.getValue();
    Integer key = pairs.getKey();
    System.out.println(key +"--->"+value);
}