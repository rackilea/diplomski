public static int maxMatrix(int [][] ints) {
    int max = ints[0][0];

    for(int i = 0; i < ints.length; i++) {
        for(int j = 0; j < ints[i].length; j++){
            max = Math.max(max, ints[i][j]);
        }
    }
    return max;
}