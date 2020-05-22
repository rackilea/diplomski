TreeMap<String, String> map = new TreeMap<>();
map.put("0060175559138", "VIP");
map.put("006017555"    , "National");
map.put("006017"       , "Local");
map.put("0060"         , "X");

String key = "0060175552020";
Entry<String, String> entry = map.floorEntry(key);
if (entry == null)
    System.out.println("Not found: " + key);
else {
    System.out.println(key);
    System.out.println(entry);
}