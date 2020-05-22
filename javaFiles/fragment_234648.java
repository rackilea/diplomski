private static final HashMap<String, String> map;  
static {
    HashMap<String, String> tmpMap = new HashMap<String, String>()
    tmpMap.put("A", "aba");
    map = Collections.unmodifiableMap(tmpMap);
}