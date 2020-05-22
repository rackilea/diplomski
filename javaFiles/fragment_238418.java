public static void zero(int[][] m, int num) {

    int rows = m.length;
    int columns = m[0].length;
    BitSet rowsToClear = new BitSet(rows);
    BitSet columnsToClear = new BitSet(columns);
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (m[i][j] == num) {
                rowsToClear.set(i);
                columnsToClear.set(j);
            }
        }
    }
    for (int i = rowsToClear.nextSetBit(0); i >= 0;
             i = rowsToClear.nextSetBit(i + 1)) {
        Arrays.fill(m[i], 0);
    }
    for (int j = columnsToClear.nextSetBit(0); j >= 0;
            j = columnsToClear.nextSetBit(j + 1)) {
        for (int i = 0; i < rows; ++i) {
            m[i][j] = 0;
        }
    }
    //return m;
}