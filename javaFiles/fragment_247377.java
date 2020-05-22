TreeMap<String,Integer> map = new TreeMap<String,Integer>();
map.put("a", 123);
map.put("ab", 234);
map.put("abcd", 5434);
String myKey = "ab";
for (Map.Entry<String,Integer> e : map.tailMap(myKey).entrySet()) {
    if (!e.getKey().startsWith(myKey)) {
        break;
    }
    System.out.println(e.getValue());
}