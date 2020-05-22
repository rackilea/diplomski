Map<Double, Double> map = new HashMap<>();
for (int i = 0; i < y1.size(); i++) {
    double oldValue = map.containsKey(y1.get(i)) ? map.get(y1.get(i)) : 0.0;

    map.put(y1.get(i), oldValue + a1.get(i));
}

y1.clear();
a1.clear();

for (Entry<Double, Double> entry : map.entrySet()) {
    y1.add(entry.getKey());
    a1.add(entry.getValue());
}