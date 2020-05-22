private static Map<String, String> myMap;
static {
    HashMap<String,String> map = new HashMap<String,String>();
    map.put("foo","bar");

    myMap = Collections.unmodifiableMap(map);
}