public static int[][][] copy(int[][][] source) {
    int[][][] target = source.clone();

    for (int i = 0; i < source.length; i++) {
        target[i] = source[i].clone();

        for (int j = 0; j < source[i].length; j++) {
            target[i][j] = source[i][j].clone();
        }
    }

    return target;
}