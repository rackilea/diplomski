public  static String convertHashMapToString(HashMap<String, String> h){
 String value = "";
 for(String s : h.keySet()){
  value += s + ":" + h.get(s) + ";";
 }
 return value;
}
public static HashMap<String, String> loadHashMapFromString(String saved){
 HashMap<String, String> value = new HashMap<String, String>();
 for(String s : saved.split(";")){
  value.put(s.split(":")[0], s.split(":")[1]);
 }
 return value;
}