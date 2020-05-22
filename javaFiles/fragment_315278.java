int[][] c = new int[a.length][b.length];
// int[] c = new int[a.length * b.length];
for(int i = 0; i < a.length; i++){
    for(int j = 0; j < b.length; b++){
        c[i][j] = a[i] * b[j];
        // c[i * a.length + j] = a[i] * b[j]; if you want to store it in a 1D array
        // Try a few examples to see why this will work for 1D array
    }
}