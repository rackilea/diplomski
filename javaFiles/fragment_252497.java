double[][] array = new double[n][n];
for(int i = 0; i < n; i++) {
    for(int j = 0; j < i; j++) {
        int value = rand.nextInt((rangeOfWeights)+1);         
        array[i][j] = value;
        array[j][i] = value;
    }
}