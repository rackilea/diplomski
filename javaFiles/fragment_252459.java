MultiMap mhm = new MultiValueMap();
String key ="";
key = "Group One";
mhm.put(key, "Item One");
mhm.put(key, "Item Two");
mhm.put(key, "Item Three");

key = "Group Two";
mhm.put(key, "Item Four");
mhm.put(key, "Item Five");

System.out.println(mhm.containsValue("Item One"));
System.out.println(mhm.containsValue("Item Nine"));