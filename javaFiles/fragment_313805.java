List<Integer> values = new ArrayList<>();
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
  if (entry.getKey() % 5 == 0) {
     values.add(entry.getValue());
  }
}