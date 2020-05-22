final Map<String, Object> m = new TreeMap<>();
m.put("A", 1);
m.put("B", 1);
m.put("C", 1);
m.put("D", 1);
m.put("E", 1);
m.put("F", 1);
m.put("G", 1);
final List<Map.Entry<String, Object>> e = new ArrayList<>(m.entrySet());
Collections.shuffle(e);
final Map<String, Object> r = new LinkedHashMap<>();
for (Map.Entry<String, Object> entry : e) {
    r.put(entry.getKey(), entry.getValue());
}