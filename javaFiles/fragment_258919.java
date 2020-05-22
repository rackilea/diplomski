List<String> keyList = new ArrayList<String>(map.keySet());
// Given 10th element's key
String key = "aKey";
int idx = keyList.indexOf(key);
for ( int i = idx ; i >= 0 ; i-- ) 
 System.out.println(map.get(keyList.get(i)));