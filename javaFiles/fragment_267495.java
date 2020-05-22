public static void main(String[] args) {

    int[][] b = new int[5][5]; // 5x5 grid

    for (int i = 0; i < 5; i++) { // loop for columns

        int min = i * 15 + 1;
        int max = (i + 1) * 15;

        for (int j = 0; j < 5; j++) { // loop for rows
            int rand;

            do {
                rand = getRandom(min, max); // generate random int between min & max values
            } while (isMatch(rand, b));

            b[j][i] = rand;
        }
    }
    /* print array values */
    for (int[] x : b)
        System.out.println(Arrays.toString(x));

}

/* return true if num is in the array b */
private static boolean isMatch(int num, int b[][]) {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (num == b[i][j]) {
                return true;
            }
        }
    }
    return false;
}

/* return integer number between min & max inclusive */
public static int getRandom(int min, int max) {
    return (int) ((Math.random() * (max + 1 - min)) + min);
}