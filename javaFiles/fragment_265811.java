List<int[]> moves = new ArrayList<>();
moves.add(new int[]{1, 2, 3});
moves.add(new int[]{4, 5, 6});
moves.add(new int[]{7, 8, 9});

int someValue = 1;
Integer maxValue = moves.stream().map(array -> array[2] * someValue).reduce(0, Integer::max);
System.out.println(maxValue);