int[] shuffle = // an array containing a permutation of [0..19]
    int[][] z = new int[20][];
    for (int i = 0; i < 20; i++) {
        int[] vy = y[i];
        int[] vz = new int[3];
        for (int j = 0; j < 3; j++) {
            vz[j] = shuffle[vy[j]];
        }
        z[shuffle[i]] = vz;
    }