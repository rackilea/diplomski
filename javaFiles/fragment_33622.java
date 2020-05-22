// from your example:

String key1 = "1";
String key2 = "1";
String key3 = "1";
String value = "111";

// insert if doesn't exist yet:

TreeMap<String,TreeMap<String,String>> map1 = map.get(key1);

if (map1 == null) {
    map1 = new TreeMap<String,TreeMap<String,String>>();
    map.put(key1, map1);
}

// and again:

TreeMap<String,String> map2 = map1.get(key2);

if (map2 == null) {
    map2 = new TreeMap<String,String>();
    map1.put(key2, map2);
}

// and now we're set up and ready to go:

map2.put(key3, map3);