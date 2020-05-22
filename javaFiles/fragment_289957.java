Map<Integer, Integer> map = new TreeMap<>();
for (int i : k) {
   if (map.containsKey(i)) {
      int value = map.get(i);
      map.put(i, ++value);
   } else {
      map.put(i, 1);
   }
}

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    int i = entry.getKey();
    int n = entry.getValue();
    System.out.println("The number " + i + " was found " + n + " times.");
}