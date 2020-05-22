Map<Integer, Integer> map = new HashMap<>();

for (int[] row : grid) {
    for (int a : row) {
        map.put(a, map.containsKey(a) ? map.get(a) + 1 : 1);
    }
}