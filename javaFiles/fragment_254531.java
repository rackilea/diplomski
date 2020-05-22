Configuration configuration = new Configuration();
Map<String, String> map = new HashMap<>();
Iterator<Map.Entry<String,String>> iterator = configuration.iterator();
while (iterator.hasNext()) {
  Map.Entry<String, String> entry = iterator.next();
  map.put(entry.getKey(), entry.getValue());
}