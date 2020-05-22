Map<String, String> mMap = new HashMap<String, String>();
mMap.put("a", "a-desc");
mMap.put("b", "b-desc");
mMap.put("c", "c-desc");

Map<String, String> sMap = new HashMap<String, String>();
sMap.put("a", "");
sMap.put("b", "");
sMap.put("c", "");

for (Map.Entry<String, String> entry : mMap.entrySet()) {
    sMap.put(entry.getKey(), mMap.get(entry.getKey());
}