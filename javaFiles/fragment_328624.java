void process(int idx, int n, int[][] x, int[] k, int value) {
    if (idx == n) {
        // all elements from the current tuple are equal to "value". 
        // add this to the global "sum" variable
        sum += value;
        return;
    }

    for (int i = 0; i < k[idx]; i++) {
        if (idx == 0) {
            // this is the outer "for", set the new value
            value = x[0][i];
        } else {
            // check if the current element from the idx'th for
            // has the same value as all previous elements
            if (x[idx][i] == value) {
                process(idx + 1, n, x, k, value);
            }
        }
    }
}