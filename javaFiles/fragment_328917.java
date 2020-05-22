public static void PlayMeBoi(String[][] gameMatrix) {
    int row_1 = -1;
    int col_1 = -1;
    int row_2 = -1;
    int col_2 = -1;

    boolean found = false;
    for (int i = 0; i < gameMatrix.length; i++) {
        if (found) break;
        for (int j = 0; j < gameMatrix[0].length; j++) {
            if ("A".equals(gameMatrix[i][j])) {
                row_1 = i;
                col_1 = j;
                found = true;
                break;
            }
        }
    }

    if (!found) {
        System.out.println("Not Found");
        return;
    }

    found = false;
    for (int i = 1; i < gameMatrix.length; i++) {
        if (found) break;
        for (int j = 1; j < gameMatrix[0].length; j++) {
            if (i * gameMatrix[0].length + j > row_1 * gameMatrix[0].length + col_1) {
                if ("A".equals(gameMatrix[i][j])) {
                    row_2 = i;
                    col_2 = j;
                    found = true;
                    break;
                }
            }
        }
    }

    System.out.println("First " + gameMatrix[row_1][col_1] + " at " + " [ " + row_1 + " ] " + "," + " [ " + col_1 + " ] ");
    if (!found) {
        System.out.println("Second Not Found");
        return;
    }
    System.out.println("Second " + gameMatrix[row_1][col_1] + " at " + " [ " + row_2 + " ] " + "," + " [ " + col_2 + " ] ");
}