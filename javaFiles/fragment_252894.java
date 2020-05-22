Map<String, String> m = new LinkedHashMap<String, String>();
...

List<String> keys = new ArrayList<String>();
for(String str: m.keySet()) {
    if(m.get(str).equals("23")) {
        keys.add(str);
    }
}