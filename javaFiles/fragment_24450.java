Map<String, Integer> counts = new HashMap<>();
for (int i = 0; i< data.length; i++) {
    for (int j = 0; j<data[i].length; j++) {
        String val = data[i][j];
        counts.put(val, counts.getOrDefault(val, 0) + 1);
    }
}

for (Map.Entry<String, Integer> entry: counts.entrySet()) {
    if (entry.getValue() >= 10) {
        System.out.println(entry.getKey());
    }
}