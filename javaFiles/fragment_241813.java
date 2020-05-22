public static int[] filterImmediary(int[] x) {

    /*
     * Construct a boolean array that will be used to indicate whether the
     * corresponding element in the int array is an immediary consecutive
     * number.
     */
    int l = x.length;
    boolean[] rem = new boolean[l];
    int numKeeps = 0;

    /*
     * Fill boolean array
     */
    for (int k = 0; k < l - 1; k++) {
        int f = 1;
        while (k + f < l && x[k] + f == x[k + f]) {
            if (k + f + 1 < l && x[k] + f + 1 == x[k + f + 1]) {
                rem[k + f] = true;
            }
            f++;
        }
        if (!rem[k]) {
            numKeeps++;
        }
    }

    /*
     * Construct a new array with no immediary consecutive numbers to return
     * instead of mutating the original array.
     */
    int[] newX = new int[numKeeps+1];
    int i = 0;
    for (int k = 0; k < l; k++) {
        if (!rem[k]) {
            newX[i] = x[k];
            i++;
        }
    }
    return newX;
}