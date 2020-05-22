public static void main(String args[]) {
    int[][] results = new int[4][3];
    results[0][0] = 2;
    results[0][1] = 3;
    results[0][2] = 5;

    for (int i = 1; i < results.length; i++) {
        for (int j = 0; j < results[0].length; j++) {
            results[i][j] = results[i - 1][j] * results[0][j] + 1;
        }
    }

    for (int i = 0; i < results.length; i++) {
        for (int j = 0; j < results[0].length; j++) {
            System.out.print(results[i][j] + "\t");
        }
        System.out.println();
    }
}