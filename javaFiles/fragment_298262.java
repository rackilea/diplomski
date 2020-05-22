public static void solve(int[][][] arrays, List<List<List<Integer>>> result, List<List<Integer>> current,
                  int row) {
    if (row == arrays.length) {
        result.add(current);
        return;
    }

    for (int j = 0; j < arrays[row].length; j++) {
        List<List<Integer>> localCurrent = new ArrayList<>(current); //Copy the previous result
        List<Integer> currentData = Arrays.stream(arrays[row][j])
                .boxed()
                .collect(Collectors.toList()); //Convert current int[] to List<Integer>
        localCurrent.add(currentData);
        solve(arrays, result, localCurrent, row + 1); 
    }
}