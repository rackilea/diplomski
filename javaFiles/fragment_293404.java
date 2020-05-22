intMap.computeIfAbsent(1, k -> new ArrayList<>()).add(2);
intMap.computeIfAbsent(1, k -> new ArrayList<>()).add(3);

intMap.computeIfAbsent(5, k -> new ArrayList<>()).add(8);

intMap.computeIfAbsent(6, k -> new ArrayList<>()).add(7);
intMap.computeIfAbsent(6, k -> new ArrayList<>()).add(9);
intMap.computeIfAbsent(6, k -> new ArrayList<>()).add(4);