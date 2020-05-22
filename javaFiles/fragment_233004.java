TreeMap<String, String> map = new TreeMap<>();
map.put("0060175559138", "VIP");
map.put("0060175551000", "Other");
map.put("006017555"    , "National");
map.put("006017"       , "Local");
map.put("0060"         , "X");

System.out.println(lookup(map, "0060175559138"));
System.out.println(lookup(map, "0060175552020"));
System.out.println(lookup(map, "0055708570068"));
System.out.println(lookup(map, "8684064893870"));