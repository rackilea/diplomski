List<Map<Integer, Long>> maps = new ArrayList<Map<Integer, Long>>();

Map<Integer, Long> all = new HashMap<Integer, Long>();
for(Map<Integer, Long> map: maps)
    all.putAll(map);

for(Map.Entry<Integer, Long> entry: all.entrySet() {
    // do something which each key/value.
}