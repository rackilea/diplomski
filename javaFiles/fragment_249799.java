Map<String, Double> map = new LinkedHashMap<String, Double>();
map.put("s",100.00);
map.put("d",80.00);
map.put("a",80.00);
map.put("e",80.00);
map.put("c", 50.00);
map.put("w", 50.00);
map.put("q", 20.00);

Map<String, Integer> newMap = new LinkedHashMap<>();

double lastVal = -1;
int i = 0;
for (Map.Entry<String, Double> entry : map.entrySet()) {
    if (entry.getValue() != lastVal)
        i++;
    newMap.put(entry.getKey(), i);
    lastVal = entry.getValue();
}
System.out.println(newMap);