// Build a map with
    final Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
    for (int[] ints : array) {
        if (sortedMap.containsKey(ints[0])) {
            sortedMap.put(ints[0], sortedMap.get(ints[0]) + ints[1]);
        } else {
            sortedMap.put(ints[0], ints[1]);
        }
    }
    int[][] sortedArray = new int[sortedMap.size()][2];
    int i = 0;
    // Convert the map to 2D array
    for (Integer integer : sortedMap.keySet()) {
        sortedArray[i][0] = integer;
        sortedArray[i][1] = sortedMap.get(integer);
        i++;
    }