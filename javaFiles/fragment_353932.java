public static boolean isPermutation(int[] a) {
    int[][] key = new int[2][a.length];
    key[0] = a;
    for (int i = 0; i < a.length; i++) {
        key[1][i] = 0;
    }
    for (int i = 0; i < a.length; i++) {
        if (a[i] > 0) {
            key[1][a[i] - 1]++;
        }
    }
    boolean keycheck = false;
    for (int i = 0; i < a.length; i++) {
        if (key[1][i] > 1) {
            keycheck = true;
            break;
        }
    }
    if (keycheck == true) {
        return false;
    } else {
        return true;
    }
}