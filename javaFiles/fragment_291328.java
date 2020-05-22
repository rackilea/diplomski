Map map1 = new HashMap<String[], String>();
map1.put(new String[]{"a", "b"}, "xyz");
map1.put(new String[]{"c", "d"}, "wrt");
map1.put(new String[]{"e", "f"}, "xyz");
map1.put(new String[]{"c", "d"}, "xyz");

MultiValueMap map2 = new MultiValueMap();
for(String[] key: map1.keySet()) {
    String value = map1.get(key);
    map2.add(value, key);
}
// now you got map2 as you want