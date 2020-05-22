private static boolean extra(int[][] data) {
    boolean found = false;
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
            if (set.contains(data[i][j])) {

                out.printf("[%d][%d] - %d\n", i, j, data[i][j]);
                found = true;
            } else {
                set.add(data[i][j]);
            }
        }
    }
    return found;
}