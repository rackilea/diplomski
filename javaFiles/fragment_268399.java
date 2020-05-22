Map<String, Set<String>> hashMap4 = new HashMap<>();
for (Map<String, String> map : Arrays.asList(hashMap1, hashMap2, hashMap3)) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
        String key = entry.getKey();
        Set<String> values = hashMap4.get(key);
        if (values == null) {
            hashMap4.put(key, values = new HashSet<>());
        }
        values.add(entry.getValue());
    }
}