HashMap<String, String> requestMap  = flatten(map);

...


public static Map<String, String> flatten(Map<String, String[]> arrayMap){
  Map<String, String> r = new HashMap<String, String>();
  for (Map.Entry<String, String[]> entry: arrayMap.entrySet()){
    String[] value = entry.getValue();
    if (value !=null && value .length>0) r.put(entry.getKey(), value[0]);
  }
  return r;
}